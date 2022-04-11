package com.parqueadero.uts.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.parqueadero.uts.models.entities.TipoVehiculo;
import com.parqueadero.uts.models.services.ITipoVehiculoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoVehiculoRestController {
	
	@Autowired
	private ITipoVehiculoService tipoVehiculoService;

	@GetMapping("/tiposVehiculos")
	public List<TipoVehiculo> index() {
		return tipoVehiculoService.findAll();
	}

	@GetMapping("/tipoVehiculo/{id}")
	public TipoVehiculo show(@PathVariable Long id) {
		return tipoVehiculoService.findById(id);
	}

	@PostMapping("/tiposVehiculos")
	public ResponseEntity<?> create(@Valid @RequestBody TipoVehiculo tipoVehiculo, BindingResult result) {

		TipoVehiculo tipoVehiculoNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			tipoVehiculoNew = this.tipoVehiculoService.save(tipoVehiculo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El tipo del vehiculo ha sido creado con éxito!");
		response.put("tipo del vehiculo", tipoVehiculoNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PutMapping("/tipoVehiculo/{id}")	
	public ResponseEntity<?> update(@Valid @RequestBody TipoVehiculo tipoVehiculo,BindingResult result,@PathVariable  Long id){
		
		TipoVehiculo currentTipo=this.tipoVehiculoService.findById(id);
		
		TipoVehiculo updateTipo=null;
		
        Map<String, Object> response=new HashMap<>();
		
		if(result.hasErrors()) {		
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo " +err.getField() +" "+err.getDefaultMessage())
			        .collect(Collectors.toList());	
		
		response.put("errors",errors);
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		
		}
		
		if(currentTipo==null){
			response.put("mensaje", "Error: no se puede editar,el tipo del vehiculo  ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);		   
			
		}
		
		try{
			currentTipo.setTipoVehiculo(tipoVehiculo.getTipoVehiculo());
			updateTipo=this.tipoVehiculoService.save(currentTipo);
			
		}catch(DataAccessException e){
			response.put("mensaje", "Error al actulizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje","el tipo del vehiculo ha sido actulizada con éxito!");
		response.put("tipo vehiculo", updateTipo);		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
		
	}

	@DeleteMapping("/tipoVehiculo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {

			TipoVehiculo tipoVehiculo = this.tipoVehiculoService.findById(id);
			this.tipoVehiculoService.delete(tipoVehiculo);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el tipo del vehiculo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "el tipo de vehiculo fue eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}


}

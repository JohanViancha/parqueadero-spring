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

import com.parqueadero.uts.models.entities.Tarifa;
import com.parqueadero.uts.models.entities.TipoVehiculo;
import com.parqueadero.uts.models.entities.Vehiculo;
import com.parqueadero.uts.models.services.IVehiculoService;
import org.springframework.security.access.annotation.Secured;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VehiculoRestController {
	
	@Autowired
	private IVehiculoService vehiculoService;

	@GetMapping("/vehiculos")
	public List<Vehiculo> index() {
		return vehiculoService.findAll();
	}

                   @Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/vehiculo/{id}")
	public Vehiculo show(@PathVariable Long id) {
		return vehiculoService.findById(id);
	}

                   @Secured({"ROLE_ADMIN"})
	@PostMapping("/vehiculos")
	public ResponseEntity<?> create(@Valid @RequestBody Vehiculo vehiculo, BindingResult result) {

		Vehiculo vehiculoNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			vehiculoNew = this.vehiculoService.save(vehiculo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El vehiculo ha sido creado con éxito!");
		response.put("vehiculo", vehiculoNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

                @Secured({"ROLE_ADMIN"})
                    @PutMapping("/vehiculo/{id}")	
	public ResponseEntity<?> update(@Valid @RequestBody Vehiculo vehiculo,BindingResult result,@PathVariable  Long id){
		
		Vehiculo currentVehiculo=this.vehiculoService.findById(id);
		
		Vehiculo updateVehiculo=null;
		
        Map<String, Object> response=new HashMap<>();
		
		if(result.hasErrors()) {		
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo " +err.getField() +" "+err.getDefaultMessage())
			        .collect(Collectors.toList());	
		
		response.put("errors",errors);
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		
		}
		
		if(currentVehiculo==null){
			response.put("mensaje", "Error: no se puede editar el vehiculo  ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);		   
			
		}
		
		try{
			currentVehiculo.setPlaca(vehiculo.getPlaca());
			currentVehiculo.setMarca(vehiculo.getMarca());
			currentVehiculo.setModelo(vehiculo.getModelo());
			
			updateVehiculo=this.vehiculoService.save(currentVehiculo);
			
		}catch(DataAccessException e){
			response.put("mensaje", "Error al actulizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje","el vehiculo ha sido actulizada con éxito!");
		response.put(" vehiculo", updateVehiculo);		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
		
	}

                @Secured({"ROLE_ADMIN"})
	@DeleteMapping("/vehiculo/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {

			Vehiculo vehiculo = this.vehiculoService.findById(id);
			this.vehiculoService.delete(vehiculo);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el vehiculo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "el vehiculo fue eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
                    @Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/vehiculo/tarifas")
	public List<Tarifa> listarTarifas(){
		return vehiculoService.findAllTarifas();
	}
	
                    @Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/vehiculo/tiposVehiculos")
	public List<TipoVehiculo> listarTiposVehiculos(){
		return vehiculoService.findAllTipoVehiculos();
	}


}

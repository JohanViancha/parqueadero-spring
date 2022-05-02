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

import com.parqueadero.uts.models.entities.Bahia;
import com.parqueadero.uts.models.services.IBahiaService;
import org.springframework.security.access.annotation.Secured;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class BahiaRestController {
	
	@Autowired
	private IBahiaService bahiaService;

	@GetMapping("/bahias")
	public List<Bahia> index() {
		return bahiaService.findAll();
	}
                   
                  @Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/bahia/{id}")
	public Bahia show(@PathVariable Long id) {
		return bahiaService.findById(id);
	}

                  @Secured({"ROLE_ADMIN"})
	@PostMapping("/bahias")
	public ResponseEntity<?> create(@Valid @RequestBody Bahia bahia, BindingResult result) {
                                    
            
                        Bahia bahiaNew = null;

                        Map<String, Object> response = new HashMap<>();

                        if (result.hasErrors()) {
                                List<String> errors = result.getFieldErrors().stream()
                                                .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                                                .collect(Collectors.toList());

                                response.put("errors", errors);
                                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

                        }

                        try {
                                bahiaNew = this.bahiaService.save(bahia);
                        } catch (DataAccessException e) {
                                response.put("mensaje", "Error al realizar el insert en la base de datos");
                                response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                        }
                        response.put("mensaje", "La bahia ha sido creado con éxito!");
                        response.put("bahia", bahiaNew);

                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
        
                    @Secured({"ROLE_ADMIN"})
	@PutMapping("/bahia/{id}")  
	public ResponseEntity<?> update(@Valid @RequestBody Bahia bahia,BindingResult result,@PathVariable  Long id){
		
		Bahia currentBahia=this.bahiaService.findById(id);
		
		Bahia updateBahia=null;
		
                                    Map<String, Object> response=new HashMap<>();
		
		if(result.hasErrors()) {		
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo " +err.getField() +" "+err.getDefaultMessage())
			        .collect(Collectors.toList());	
		
		response.put("errors",errors);
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		
		}
		
		if(currentBahia==null){
			response.put("mensaje", "Error: no se puede editar, la bahia  ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);		   
			
		}
		
		try{
			currentBahia.setNombreParq(bahia.getNombreParq());
			currentBahia.setEstado(bahia.isEstado());
			updateBahia=this.bahiaService.save(currentBahia);
			
		}catch(DataAccessException e){
			response.put("mensaje", "Error al actulizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje","la bahia ha sido actulizada con éxito!");
		response.put("bahia", updateBahia);		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
		
	}
                    
                  @Secured({"ROLE_ADMIN"})
	@DeleteMapping("/bahia/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {

			Bahia bahia = this.bahiaService.findById(id);
			this.bahiaService.delete(bahia);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la bahia en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La bahia eliminado con éxito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}


}

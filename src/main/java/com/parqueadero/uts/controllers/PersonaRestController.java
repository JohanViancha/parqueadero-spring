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

import com.parqueadero.uts.models.entities.Persona;
import com.parqueadero.uts.models.services.IPersonaService;
import org.springframework.security.access.annotation.Secured;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonaRestController {

	@Autowired
	private IPersonaService personaService;

	@GetMapping("/personas")
	public List<Persona> index() {
		return personaService.findAll();
	}

                  //  @Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/persona/{id}")
	public Persona show(@PathVariable Long id) {
		return personaService.findById(id);
	}

                    // @Secured({"ROLE_ADMIN"})
	@PostMapping("/personas")
	public ResponseEntity<?> create(@Valid @RequestBody Persona persona, BindingResult result) {

		Persona personaNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			personaNew = this.personaService.save(persona);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La persona ha sido creado con ??xito!");
		response.put("persona", personaNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

                  //  @Secured({"ROLE_ADMIN"})
	@PutMapping("/persona/{id}")	
	public ResponseEntity<?> update(@Valid @RequestBody Persona persona,BindingResult result,@PathVariable  Long id){
		
		Persona currentPersona=this.personaService.findById(id);
		
		Persona updatePersona=null;
		
        Map<String, Object> response=new HashMap<>();
		
		if(result.hasErrors()) {		
			List<String> errors= result.getFieldErrors()
					.stream()
					.map(err -> "El campo " +err.getField() +" "+err.getDefaultMessage())
			        .collect(Collectors.toList());	
		
		response.put("errors",errors);
		 return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
		
		}
		
		if(currentPersona==null){
			response.put("mensaje", "Error: no se puede editar, la persona  ID: ".concat(id.toString())
					.concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);		   
			
		}
		
		try{
			currentPersona.setNombre(persona.getNombre());
			currentPersona.setApellido(persona.getApellido());
			currentPersona.setDocumento(persona.getDocumento());
			updatePersona=this.personaService.save(currentPersona);
			
		}catch(DataAccessException e){
			response.put("mensaje", "Error al actulizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));	
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje","la persona ha sido actulizada con ??xito!");
		response.put("persona", updatePersona);		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);	
		
	}

                  //  @Secured({"ROLE_ADMIN"})
	@DeleteMapping("/persona/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();
		try {

			Persona persona = this.personaService.findById(id);
			this.personaService.delete(persona);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la persona en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La persona eliminado con ??xito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

}
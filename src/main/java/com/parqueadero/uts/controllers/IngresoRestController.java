/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.controllers;

import com.parqueadero.uts.models.entities.Factura;
import com.parqueadero.uts.models.entities.Ingreso;
import com.parqueadero.uts.models.services.IFacturaService;
import com.parqueadero.uts.models.services.IIngresoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class IngresoRestController {
    
     @Autowired
    private IIngresoService ingresoService;
    
    
                   @GetMapping("/ingresos")
	public List<Ingreso> index() {
		return ingresoService.findAll();
	}
                    
                //  @Secured({"ROLE_ADMIN","ROLE_USER"})
                @GetMapping("/ingreso/{id}")
	public Ingreso show(@PathVariable Long id) {
		return ingresoService.findById(id);
	}

                //   @Secured({"ROLE_ADMIN"})
	@PostMapping("/ingresos")
	public ResponseEntity<?> registerEntry(@Valid @RequestBody Ingreso ingreso, BindingResult result) {

                        System.out.println(ingreso.getPersona());
                        System.out.println(ingreso.getUsuario());
                        System.out.println(ingreso.getVehiculo());
                        System.out.println(ingreso.getBahia());
                        Ingreso ingresoNew = null;

                        Map<String, Object> response = new HashMap<>();

                        if (result.hasErrors()) {
                                List<String> errors = result.getFieldErrors().stream()
                                                .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                                                .collect(Collectors.toList());

                                response.put("errors", errors);
                                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

                        }

                        try {
                                ingresoNew = this.ingresoService.registerEntry(ingreso);
                        } catch (DataAccessException e) {
                                response.put("mensaje", "Error al realizar el insert en la base de datos");
                                response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
                                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
                        }
                        response.put("mensaje", "El ingreso ha sido creado con éxito!");
                        response.put("Ingreso", ingresoNew);

                        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
    
}

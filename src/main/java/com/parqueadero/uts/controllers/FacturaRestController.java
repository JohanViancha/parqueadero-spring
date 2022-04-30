/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.controllers;

import com.parqueadero.uts.models.entities.Bahia;
import com.parqueadero.uts.models.entities.Factura;
import com.parqueadero.uts.models.services.IBahiaService;
import com.parqueadero.uts.models.services.IFacturaService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class FacturaRestController {
    
    @Autowired
    private IFacturaService facturaService;
    
    
                   @GetMapping("/facturas")
	public List<Factura> index() {
		return facturaService.findAll();
	}
        
                @GetMapping("/factura/{id}")
	public Factura show(@PathVariable Long id) {
		return facturaService.findById(id);
	}

	@PostMapping("/facturas")
	public ResponseEntity<?> create(@Valid @RequestBody Factura factura, BindingResult result) {

		Factura facturaNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}

		try {
			facturaNew = this.facturaService.registerInvoice(factura);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La factura ha sido creado con éxito!");
		response.put("Factura", facturaNew);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

    
}

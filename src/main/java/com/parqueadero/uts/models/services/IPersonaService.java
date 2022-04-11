package com.parqueadero.uts.models.services;

import java.util.List;
import com.parqueadero.uts.models.entities.Persona;

public interface IPersonaService {
	
    public List<Persona> findAll();
	
	public Persona findById(Long id);
	
	public Persona save(Persona cliente);
	
	public void delete(Persona cliente);

}
package com.parqueadero.uts.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parqueadero.uts.models.entities.Persona;
import com.parqueadero.uts.models.dao.IPersonaDao;

@Service
public class PersonaServiceImpl  implements IPersonaService {
	
	@Autowired
	private IPersonaDao personaDao;
	

	@Override
	@Transactional(readOnly=true)
	public List<Persona> findAll() {
		return (List<Persona>) personaDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true)
	public Persona findById(Long id) {
		return  personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona cliente) {
		 return personaDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Persona cliente) {
		personaDao.delete(cliente);
		
	}

}

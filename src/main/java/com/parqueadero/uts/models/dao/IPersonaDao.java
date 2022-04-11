package com.parqueadero.uts.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.parqueadero.uts.models.entities.Persona;


public interface IPersonaDao extends CrudRepository<Persona,Long> {
	

}
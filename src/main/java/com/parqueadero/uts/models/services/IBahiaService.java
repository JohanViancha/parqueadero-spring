package com.parqueadero.uts.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parqueadero.uts.models.entities.Bahia;

@Service
public interface IBahiaService {
public List<Bahia> findAll();
	
	public Bahia findById(Long id);
	
	public Bahia save(Bahia bahia);
	
	public void delete(Bahia bahia);
}

package com.parqueadero.uts.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.parqueadero.uts.models.entities.Bahia;

@Component
public interface IBahiaDao extends CrudRepository<Bahia	, Long> {

}

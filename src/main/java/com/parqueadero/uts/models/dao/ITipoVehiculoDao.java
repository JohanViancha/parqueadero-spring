package com.parqueadero.uts.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.parqueadero.uts.models.entities.Tarifa;
import com.parqueadero.uts.models.entities.TipoVehiculo;
@Component
public interface ITipoVehiculoDao extends CrudRepository<TipoVehiculo,Long>{
	@Query("from Tarifa")
	public List<Tarifa> findAllTarifas();
}

package com.parqueadero.uts.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.parqueadero.uts.models.entities.Tarifa;
import com.parqueadero.uts.models.entities.TipoVehiculo;
import com.parqueadero.uts.models.entities.Vehiculo;
@Component
public interface IVehiculoDao extends CrudRepository<Vehiculo,Long>{
	@Query("from Tarifa")
	public List<Tarifa> findAllTarifas();
	
	@Query("from TipoVehiculo")
	public List<TipoVehiculo> findAllTipoVehiculos();
}

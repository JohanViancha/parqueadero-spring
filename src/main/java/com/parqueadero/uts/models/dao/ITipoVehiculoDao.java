package com.parqueadero.uts.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.parqueadero.uts.models.entities.TipoVehiculo;
@Component
public interface ITipoVehiculoDao extends CrudRepository<TipoVehiculo,Long>{

}

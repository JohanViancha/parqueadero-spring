package com.parqueadero.uts.models.services;

import java.util.List;


import com.parqueadero.uts.models.entities.TipoVehiculo;


public interface ITipoVehiculoService {
public List<TipoVehiculo> findAll();
	
	public TipoVehiculo findById(Long id);
	
	public TipoVehiculo save(TipoVehiculo tipoVehiculo);
	
	public void delete(TipoVehiculo tipoVehiculo);
}

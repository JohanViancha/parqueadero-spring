package com.parqueadero.uts.models.services;

import java.util.List;

import com.parqueadero.uts.models.entities.Tarifa;
import com.parqueadero.uts.models.entities.TipoVehiculo;
import com.parqueadero.uts.models.entities.Vehiculo;


public interface IVehiculoService {
public List<Vehiculo> findAll();
	
	public Vehiculo findById(Long id);
	
	public Vehiculo save(Vehiculo vehiculo);
	
	public void delete(Vehiculo vehiculo);
	
	public List<Tarifa> findAllTarifas();
	
	public List<TipoVehiculo> findAllTipoVehiculos();
}

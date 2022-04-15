package com.parqueadero.uts.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parqueadero.uts.models.dao.IVehiculoDao;
import com.parqueadero.uts.models.entities.Tarifa;
import com.parqueadero.uts.models.entities.TipoVehiculo;
import com.parqueadero.uts.models.entities.Vehiculo;
@Service
public class VehiculoImpl implements IVehiculoService {
	@Autowired
	private IVehiculoDao vehiculoDao;
	

	@Override
	@Transactional(readOnly=true)
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>) vehiculoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Vehiculo findById(Long id) {
		return  vehiculoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Vehiculo save(Vehiculo vehiculo) {
		 return vehiculoDao.save(vehiculo);
	}

	@Override
	@Transactional
	public void delete(Vehiculo vehiculo) {
		vehiculoDao.delete(vehiculo);		
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Tarifa> findAllTarifas() {
		return  vehiculoDao.findAllTarifas();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<TipoVehiculo> findAllTipoVehiculos() {
		return  vehiculoDao.findAllTipoVehiculos();
	}
	
	

}

	


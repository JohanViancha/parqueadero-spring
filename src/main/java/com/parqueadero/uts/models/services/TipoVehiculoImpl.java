package com.parqueadero.uts.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parqueadero.uts.models.dao.ITipoVehiculoDao;
import com.parqueadero.uts.models.entities.Tarifa;
import com.parqueadero.uts.models.entities.TipoVehiculo;
@Service
public class TipoVehiculoImpl implements ITipoVehiculoService {
	@Autowired
	private ITipoVehiculoDao tipoDao;
	

	@Override
	@Transactional(readOnly=true)
	public List<TipoVehiculo> findAll() {
		return (List<TipoVehiculo>) tipoDao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public TipoVehiculo findById(Long id) {
		return  tipoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TipoVehiculo save(TipoVehiculo tipovehiculo) {
		 return tipoDao.save(tipovehiculo);
	}

	@Override
	@Transactional
	public void delete(TipoVehiculo tipovehiculo) {
		tipoDao.delete(tipovehiculo);		
	}
	
	/*@Override
	@Transactional(readOnly=true)
	public List<Tarifa> findAllTarifas() {
		return (List<Tarifa>) tipoDao.findAllTarifas();
	}*/
	
	

}

	


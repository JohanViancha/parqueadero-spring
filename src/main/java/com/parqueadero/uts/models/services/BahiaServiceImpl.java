package com.parqueadero.uts.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parqueadero.uts.models.dao.IBahiaDao;
import com.parqueadero.uts.models.entities.Bahia;
@Service
public class BahiaServiceImpl implements IBahiaService {
	@Autowired
	private IBahiaDao bahiaDao;
	

	@Override
	@Transactional(readOnly=true)
	public List<Bahia> findAll() {
		return (List<Bahia>) bahiaDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true)
	public Bahia findById(Long id){
		return  bahiaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Bahia save(Bahia bahia) {
		 return bahiaDao.save(bahia);
	}

	@Override
	@Transactional
	public void delete(Bahia bahia) {
		bahiaDao.delete(bahia);
		
	}

}

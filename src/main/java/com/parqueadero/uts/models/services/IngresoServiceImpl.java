/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;


import com.parqueadero.uts.models.dao.IFacturaDao;
import com.parqueadero.uts.models.dao.IIngresoDao;
import com.parqueadero.uts.models.entities.Ingreso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author USUARIO
 */
@Service
public class IngresoServiceImpl implements IIngresoService {
    
     @Autowired
    private IIngresoDao ingresoDao;
	

    @Override
    @Transactional(readOnly=true)
    public List<Ingreso> findAll() {
       
        return (List<Ingreso>) ingresoDao.findAll();
        
    }

    @Override
    @Transactional(readOnly=true)
    public Ingreso findById(Long id) {

        return ingresoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Ingreso registerEntry(Ingreso ingreso) {
        return ingresoDao.save(ingreso);
    }
    
 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;

import com.parqueadero.uts.models.dao.IFacturaDao;
import com.parqueadero.uts.models.dao.IPersonaDao;
import com.parqueadero.uts.models.entities.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USUARIO
 */
@Service
public class FacturaServiceImpl  implements IFacturaService {

    @Autowired
    private IFacturaDao facturaDao;
	

    @Override
    @Transactional(readOnly=true)
    public List<Factura> findAll() {
       
        return (List<Factura>) facturaDao.findAll();
    }

    @Override
     @Transactional(readOnly=true)
    public Factura findById(Long id) {
         return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura registerInvoice(Factura factura) {

        return facturaDao.save(factura);
    }
    
}

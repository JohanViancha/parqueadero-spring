/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.dao;

import com.parqueadero.uts.models.entities.Bahia;
import com.parqueadero.uts.models.entities.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author USUARIO
 */
@Component
public interface IFacturaDao extends CrudRepository<Factura, Long>{
    
}

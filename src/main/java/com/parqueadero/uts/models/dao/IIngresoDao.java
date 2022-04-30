/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parqueadero.uts.models.dao;

import com.parqueadero.uts.models.entities.Ingreso;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface IIngresoDao extends CrudRepository<Ingreso, Long>  {
    
}

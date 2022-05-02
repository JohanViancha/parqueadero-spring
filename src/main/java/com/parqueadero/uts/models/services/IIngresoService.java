/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;

import com.parqueadero.uts.models.entities.Ingreso;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

public interface IIngresoService {
    
     public List<Ingreso> findAll();
    
    public Ingreso findById(Long id);
    
    public Ingreso registerEntry(Ingreso ingreso);
    
  
    
}

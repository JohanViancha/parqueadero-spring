/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;

import com.parqueadero.uts.models.entities.Factura;
import com.parqueadero.uts.models.entities.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

public interface IFacturaService {
    
     public List<Factura> findAll();
    
    public Factura findById(Long id);
    
    public Factura registerInvoice(Factura factura);
    
}

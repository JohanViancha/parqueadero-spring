/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;

import com.parqueadero.uts.models.entities.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */

@Service
public interface IUsuarioService {
    
    
     public List<Usuario> findAll();
    
    public Usuario findById(Long id);
    
    public Usuario save(Usuario usuario);
    
    public void delete(Usuario usuario);
    
}

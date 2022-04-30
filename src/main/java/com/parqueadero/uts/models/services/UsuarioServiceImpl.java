/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;

import com.parqueadero.uts.models.dao.IFacturaDao;
import com.parqueadero.uts.models.dao.IUsuarioDao;
import com.parqueadero.uts.models.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USUARIO
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
    
    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Usuario findById(Long id) {
         return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
         usuarioDao.delete(usuario);
    }
    
}

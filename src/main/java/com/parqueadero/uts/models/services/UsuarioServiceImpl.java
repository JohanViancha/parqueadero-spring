/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.services;


import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.parqueadero.uts.models.dao.IUsuarioDao;
import com.parqueadero.uts.models.entities.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author USUARIO
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService,UserDetailsService  {
    
    private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);
    
    @Autowired
    private IUsuarioDao usuarioDao;

    
    
    @Override
    @Transactional(readOnly=true)
    public Usuario findByUsername(String username) {
        
        System.out.println(usuarioDao.findByUsername(username).getPersona().getNombre());
            return usuarioDao.findByUsername(username);
    }
    
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
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Usuario usuario=usuarioDao.findByUsername(username);

            if(usuario==null){
              logger.error("Error en el login: no existe el usuario "+username+" en el sistema!");
              throw new UsernameNotFoundException("Error en el login: no existe el usuario " +username+ " en el sistema!");
            }

            List<GrantedAuthority> authorities = usuario.getRoles()
                            .stream()
                            .map(role-> new SimpleGrantedAuthority(role.getNombre()))
                            .peek(authority-> logger.info("Role: "+authority.getAuthority()))
                            .collect(Collectors.toList());

            return new User(usuario.getUsername(),usuario.getPassword(),usuario.getEnabled(),true,true,true,authorities);


    }


    
    
}

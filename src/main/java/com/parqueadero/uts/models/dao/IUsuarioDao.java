/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.parqueadero.uts.models.dao;

import com.parqueadero.uts.models.entities.Factura;
import com.parqueadero.uts.models.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author USUARIO
 */
@Component
public interface IUsuarioDao extends CrudRepository<Usuario, Long>  {
                public Usuario findByEmail(String email);
	
	@Query("select u from Usuario u where u.email=?1")	
	public Usuario findByEmail2(String email);
}

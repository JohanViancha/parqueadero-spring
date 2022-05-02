/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{
        
                   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long Id;
	
	@NotNull(message="no puede estar vacio")
	@Size(min=3, max=30, message="el tamaño debe estar entre 3 y 30")	
	@Column(name="username",nullable=false, unique=true)
	private String username;
        
                @NotNull(message="no puede estar vacio")
	@Size(min=8, max=255, message="el tamaño debe estar entre 8 y 255")	
	@Column(name="password",nullable=false)
	private String password;
                
                @NotNull(message=" no puede ser vacia")
                 @ManyToOne(fetch=FetchType.LAZY)
                @JoinColumn(name="persona_id")
                @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
                private Persona persona;
                
                private Boolean enabled;
                
                @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns = @JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames= {"usuario_id","role_id"})})
	private List<Role> roles;

                    public Boolean getEnabled() {
                        return enabled;
                    }

                    public void setEnabled(Boolean enabled) {
                        this.enabled = enabled;
                    }
	

                    public Long getId() {
                        return Id;
                    }

                    public void setId(Long Id) {
                        this.Id = Id;
                    }

                    public String getUsername() {
                        return username;
                    }

                    public void setUsername(String username) {
                        this.username = username;
                    }
                    
                    public String getPassword() {
                        return password;
                    }

                    public void setPassword(String password) {
                        this.password = password;
                    }

                    public Persona getPersona() {
                        return persona;
                    }

                    public void setPersona(Persona persona) {
                        this.persona = persona;
                    }

                    public List<Role> getRoles() {
                        return roles;
                    }

                    public void setRoles(List<Role> roles) {
                        this.roles = roles;
                    }

                    @Override
                    public String toString() {
                        return "Usuario{" + "Id=" + Id + ", username=" + username + ", password=" + password + ", persona=" + persona + ", enabled=" + enabled + ", roles=" + roles + '}';
                    }

                
                    
                
}

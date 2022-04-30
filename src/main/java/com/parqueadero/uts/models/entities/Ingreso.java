/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author USUARIO
 */

@Entity
@Table(name = "ingresos")
public class Ingreso  implements Serializable {
    
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)	
            private Long Id;

            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="persona_id", nullable=false)
            private Persona persona;
            
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="vehiculo_id", nullable=false)
            private Vehiculo vehiculo;
            
            
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="usuario_id", nullable=false)
            private Usuario usuario;
            
            
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="bahia_id", nullable=false)
            private Bahia bahia;
            
            @Column(name="fecha_hora_entrada", nullable=false)
            @Temporal(TemporalType.DATE)
            private Date createAt;

            public Long getId() {
                return Id;
            }

            public void setId(Long Id) {
                this.Id = Id;
            }

            public Persona getPersona() {
                return persona;
            }

            public void setPersona(Persona persona) {
                this.persona = persona;
            }

            public Vehiculo getVehiculo() {
                return vehiculo;
            }

            public void setVehiculo(Vehiculo vehiculo) {
                this.vehiculo = vehiculo;
            }

            public Usuario getUsuario() {
                return usuario;
            }

            public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
            }

            public Bahia getBahia() {
                return bahia;
            }

            public void setBahia(Bahia bahia) {
                this.bahia = bahia;
            }

            public Date getCreateAt() {
                return createAt;
            }

            public void setCreateAt(Date createAt) {
                this.createAt = createAt;
            }
    
            
    
            
}

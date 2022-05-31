/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parqueadero.uts.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;

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

            
            @NotNull(message=" no puede ser vacia")
            @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.MERGE)
            @JoinColumn(name="persona_id")
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
            private Persona persona;
            
            
            @NotNull(message=" no puede ser vacia")
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="vehiculo_id")
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})     
            private Vehiculo vehiculo;
             
             
             
            @NotNull(message=" no puede ser vacia")
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="usuario_id")
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})     
            private Usuario usuario;
            
             @NotNull(message=" no puede ser vacia")
            @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name="bahia_id")
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})               
            private Bahia bahia;
            
            //@NotNull(message="no puede estar vacio")
            @Column(name="fecha_hora_entrada", nullable=false)
            @Temporal(TemporalType.TIMESTAMP)
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

    @Override
    public String toString() {
        return "Ingreso{" + "Id=" + Id + ", persona=" + persona + ", vehiculo=" + vehiculo + ", usuario=" + usuario + ", bahia=" + bahia + ", createAt=" + createAt + '}';
    }
    
            
            
    
            
}

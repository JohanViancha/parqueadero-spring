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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author USUARIO
 */

@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)	
            private Long Id;
      
            @NotNull(message="no puede estar vacio")
            @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
            @ManyToOne(fetch=FetchType.LAZY,  cascade=CascadeType.MERGE)
            @JoinColumn(name="ingreso_id",nullable=false)
          
            private Ingreso ingreso;
            
            @NotNull(message="no puede estar vacio")
             @Column(name="fecha_hora_salida",nullable=false)
            @Temporal(TemporalType.TIMESTAMP)
            private Date fechaSalida;
             
            @NotNull(message="no puede estar vacio")
             @Column(name="valor_pago",nullable=false)
            private Double valorPago;

            public Long getId() {
                return Id;
            }

            public void setId(Long Id) {
                this.Id = Id;
            }

            public Ingreso getIngreso() {
                return ingreso;
            }

            public void setIngreso(Ingreso ingreso) {
                this.ingreso = ingreso;
            }

            public Date getFechaSalida() {
                return fechaSalida;
            }

            public void setFechaSalida(Date fechaSalida) {
                this.fechaSalida = fechaSalida;
            }

            public Double getValorPago() {
                return valorPago;
            }

    @Override
    public String toString() {
        return "Factura{" + "Id=" + Id + ", ingreso=" + ingreso + ", fechaSalida=" + fechaSalida + ", valorPago=" + valorPago + '}';
    }
            
            

            public void setValorPago(Double valorPago) {
                this.valorPago = valorPago;
            }
             
             
    
}

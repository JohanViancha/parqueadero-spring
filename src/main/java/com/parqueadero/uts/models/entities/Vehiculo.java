package com.parqueadero.uts.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vehiculos")
public class Vehiculo  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
                   @NotNull(message = "no puede estar vacio")
	@Column(nullable=false, unique=true,name="placa")
	private String placa;
	
	@NotNull(message = "no puede estar vacio")
	@Column( nullable = false,name="marca")
	private String marca;
	
                    @NotNull(message = "no puede estar vacio")
	@Column( nullable = false,name="modelo")
	private String modelo;
	
	@NotNull(message="el tipo del vehiculo  no puede ser vacia")
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private TipoVehiculo tipoVehiculo;
	
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

                    @Override
                    public String toString() {
                        return "Vehiculo{" + "Id=" + Id + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", tipoVehiculo=" + tipoVehiculo + '}';
                    }
        
        
                    
	
	private static final long serialVersionUID = 1L;
	
        
	
}

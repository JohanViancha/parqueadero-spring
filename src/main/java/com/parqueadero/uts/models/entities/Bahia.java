package com.parqueadero.uts.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="bahia")
public class Bahia implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long Id;
	
	@NotEmpty(message="no puede estar vacio")
	@Size(min=3, max=30, message="el tamaño debe estar entre 3 y 30")	
	@Column(name="nom_parq",nullable=false)
	private String nombreParq;
	
	@NotEmpty(message="no puede estar vacio")	
	@Column(name="estado_parq",nullable=false)
	private boolean estado;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombreParq() {
		return nombreParq;
	}

	public void setNombreParq(String nombreParq) {
		this.nombreParq = nombreParq;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	private static final long serialVersionUID = 1L;
}

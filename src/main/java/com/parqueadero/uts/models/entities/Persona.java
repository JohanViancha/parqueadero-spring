package com.parqueadero.uts.models.entities;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "personas")
public class Persona implements Serializable {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long Id;
	
	@NotNull(message="no puede estar vacio")
	@Size(min=3, max=30, message="el tamaño debe estar entre 3 y 30")	
	@Column(name="nom_persona",nullable=false)
	private String nombre;
	
	@NotNull(message="no puede estar vacio")
	@Size(min=3, max=30, message="el tamaño debe estar entre 3 y 30")	
	@Column(name="ape_persona",nullable=false)
	private String apellido;
	
                   @NotNull(message="no puede estar vacio")
	@Column(name="num_documento",nullable=false)
	private Long documento;

                    public Long getId() {
                        return Id;
                    }

                    public void setId(Long Id) {
                        this.Id = Id;
                    }
         
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + '}';
    }
	
        
        
	private static final long serialVersionUID = 1L;
	
}

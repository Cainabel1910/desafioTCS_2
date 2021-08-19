package com.bismark.rest.webservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "uni_especialidad")
public class Especialidad {

	@Id
	@GeneratedValue
	private int idEspecialidad;
	private String nombreEspecialidad;
	
	public Especialidad() {
	}

	public Especialidad(int idEspecialidad, String nombreEspecialidad) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	
}

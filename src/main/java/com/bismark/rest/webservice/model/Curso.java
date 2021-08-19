package com.bismark.rest.webservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uni_curso")
public class Curso {
	
	@Id
	@GeneratedValue
	private int idCurso;
	private int idDocente;
	private String nombreCurso;
	private int idEspecialidad;
	
	public Curso() {
	}

	public Curso(int idCurso, int idDocente, String nombreCurso, int idEspecialidad) {
		super();
		this.idCurso = idCurso;
		this.idDocente = idDocente;
		this.nombreCurso = nombreCurso;
		this.idEspecialidad = idEspecialidad;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdDocente() {
		return idDocente;
	}

	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	
}

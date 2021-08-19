package com.bismark.rest.webservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "uni_notas")
public class Nota {
	@Id
	@GeneratedValue
	private int idNota;
	private int idCurso;
	private double nota;
	private String usuario;
	
	@Transient
	private String curso;
	
	@Transient
	private String docente;
	
	@Transient
	private String especialidad;
	
	@Transient
	private String alumno;
	
	
	public Nota() {
	}
	
	public Nota(int idNota, int idCurso, double nota, String usuario) {
		super();
		this.idNota = idNota;
		this.idCurso = idCurso;
		this.nota = nota;
		this.usuario = usuario;
	}
	
	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	
}

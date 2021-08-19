package com.bismark.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismark.rest.webservice.dao.AlumnoRepossitory;
import com.bismark.rest.webservice.model.Alumno;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepossitory alumnoRepositorio;
	
	public List<Alumno> obtenerAlumno(){
		return alumnoRepositorio.findAll();
	}
	
	public String registrarAlumno(Alumno alumno) {
		alumnoRepositorio.save(alumno);
		return "Alumno registrado con exito";
	}
}

package com.bismark.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismark.rest.webservice.dao.EspecialidadRepossitory;
import com.bismark.rest.webservice.model.Especialidad;

@Service
public class EspecialidadService {

	@Autowired
	private EspecialidadRepossitory especialidadRepositorio;
	
	public List<Especialidad> obtenerEspecialidad(){
		return especialidadRepositorio.findAll();
	}
	
	public String registarEspecialidad(Especialidad especialidad) {
		especialidadRepositorio.save(especialidad);
		return "Especialidad registrada con exito";
	}
}

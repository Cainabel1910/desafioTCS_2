package com.bismark.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismark.rest.webservice.dao.DocenteRepossitory;
import com.bismark.rest.webservice.model.Docente;

@Service
public class DocenteService {

	@Autowired
	private DocenteRepossitory docenteRepositorio;
	
	public List<Docente> obtenerDocente(){
		return docenteRepositorio.findAll();
	}
	
	public String registrarDocente(Docente docente) {
		docenteRepositorio.save(docente);
		return "Docente registrado con exito";
	}
}

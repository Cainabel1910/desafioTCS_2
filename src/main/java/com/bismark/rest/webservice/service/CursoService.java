package com.bismark.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismark.rest.webservice.dao.CursoRepossitory;
import com.bismark.rest.webservice.model.Curso;

@Service
public class CursoService {

	
	@Autowired
	private CursoRepossitory cursoRepositorio;
	
	
	public List<Curso> obtenerCurso(){
		return cursoRepositorio.findAll();
	}
	
	public String registrarCurso(Curso curso) {
		cursoRepositorio.save(curso);
		return "Curso registrado con exito";
	}
}

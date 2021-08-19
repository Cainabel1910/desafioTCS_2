package com.bismark.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismark.rest.webservice.model.Nota;
import com.bismark.rest.webservice.dao.NotaRepossitory;

@Service
public class NotaService {
		
	@Autowired
	private NotaRepossitory notaRepositorio;
	
	public List<Nota> obtenerNota(){
		return notaRepositorio.findAll();
	}
	
	public String registrarNota(Nota nota) {
		notaRepositorio.save(nota);
		return "Nota registrada con exito";
	}

}

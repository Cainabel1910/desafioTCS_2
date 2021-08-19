package com.bismark.rest.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bismark.rest.webservice.model.Docente;
import com.bismark.rest.webservice.service.DocenteService;

@RestController
@RequestMapping("/rest/docente")
public class DocenteController {

	@Autowired
	private DocenteService docenteService;
	
	
	@GetMapping
	public ResponseEntity<Docente> obtenerDocente(){
		List<Docente> docentes = docenteService.obtenerDocente();
		return new ResponseEntity(docentes, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> registrarDocente(@RequestBody Docente docente){
		String respuesta = docenteService.registrarDocente(docente);
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}
	
}

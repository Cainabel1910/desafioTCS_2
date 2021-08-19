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

import com.bismark.rest.webservice.model.Especialidad;
import com.bismark.rest.webservice.service.EspecialidadService;

@RestController
@RequestMapping("/rest/especialidad")
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping
	public ResponseEntity<Especialidad> obtenerEspecialidad(){
		List<Especialidad> especialidades = especialidadService.obtenerEspecialidad();
		return new ResponseEntity(especialidades, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> registarEspecialidad(@RequestBody Especialidad especialidad){
		String respuesta = especialidadService.registarEspecialidad(especialidad);
		return new ResponseEntity(respuesta, HttpStatus.OK);
		
	}
}

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

import com.bismark.rest.webservice.model.Alumno;
import com.bismark.rest.webservice.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping
	public ResponseEntity<Alumno> obtenerAlumno(){
		List<Alumno> alumnos = alumnoService.obtenerAlumno();
		return new ResponseEntity(alumnos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> registrarAlumno(@RequestBody Alumno alumno){
		String respuesta = alumnoService.registrarAlumno(alumno);
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}
}

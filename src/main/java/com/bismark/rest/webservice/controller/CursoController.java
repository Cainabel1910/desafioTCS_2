package com.bismark.rest.webservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bismark.rest.webservice.service.CursoService;
import com.bismark.rest.webservice.service.DocenteService;
import com.bismark.rest.webservice.service.EspecialidadService;
import com.bismark.rest.webservice.model.Curso;
import com.bismark.rest.webservice.model.Docente;
import com.bismark.rest.webservice.model.Especialidad;


@RestController
@RequestMapping("/rest/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private EspecialidadService especialidadService;
	
    boolean banderaDocente;
    boolean banderaEspecialidad;
	
	@GetMapping
	public ResponseEntity<Curso> obtenerCurso(){
		List<Curso> cursos = cursoService.obtenerCurso();
		return new ResponseEntity(cursos, HttpStatus.OK);
	}
	
	@RequestMapping
	public ResponseEntity<String> registrarCurso(@RequestBody Curso curso){
		banderaDocente = false;
		banderaEspecialidad = false;
		String respuesta = "";
		List<Docente> docentes = docenteService.obtenerDocente();
		List<Especialidad> especialidades = especialidadService.obtenerEspecialidad();
		
		docentes.stream().forEach((p)-> {
	    	if (p.getIdDocente() == curso.getIdDocente()) {
	    		banderaDocente = true;
			}
	     });
		
		if (!banderaDocente) {
			respuesta = "Error. Docente no registrado.";
			return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		especialidades.stream().forEach((p)-> {
	    	if (p.getIdEspecialidad() == curso.getIdEspecialidad()) {
	    		banderaEspecialidad = true;
			}
	     });
		
		if (!banderaEspecialidad) {
			respuesta = "Error. Especialidad no registrado.";
			return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		respuesta = cursoService.registrarCurso(curso);
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}
	
}

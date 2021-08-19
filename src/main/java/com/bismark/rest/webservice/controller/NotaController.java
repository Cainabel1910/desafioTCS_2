package com.bismark.rest.webservice.controller;

import java.util.ArrayList;
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
import com.bismark.rest.webservice.model.Curso;
import com.bismark.rest.webservice.model.Docente;
import com.bismark.rest.webservice.model.Especialidad;
import com.bismark.rest.webservice.model.Nota;
import com.bismark.rest.webservice.service.AlumnoService;
import com.bismark.rest.webservice.service.CursoService;
import com.bismark.rest.webservice.service.DocenteService;
import com.bismark.rest.webservice.service.EspecialidadService;
import com.bismark.rest.webservice.service.NotaService;

@RestController
@RequestMapping("/rest/nota")
public class NotaController {
	
	@Autowired
	private NotaService notaService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private DocenteService docenteService;
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private AlumnoService alumnoService;
	
	boolean banderaCurso;
	boolean banderaUsuario;
	
	@GetMapping
	public ResponseEntity<Nota> list(@RequestBody Nota nota) {
        List<Nota> notas = notaService.obtenerNota();
        List<Nota> notasUsuario = new ArrayList<Nota>();
        List<Curso> cursos = cursoService.obtenerCurso();
        List<Docente> docentes = docenteService.obtenerDocente();
        List<Especialidad> especialidades = especialidadService.obtenerEspecialidad();
        List<Alumno> alumnos = alumnoService.obtenerAlumno();
        
        
        notas.stream().forEach((p)-> {
        	
        	cursos.stream().forEach((c)->{
        		if(p.getIdCurso() == c.getIdCurso()) {
        			p.setCurso(c.getNombreCurso());
        		}
        		docentes.stream().forEach((d)->{
            		if(c.getIdDocente() == d.getIdDocente()) {
            			p.setDocente(d.getNombre()+" "+d.getApellidoPaterno()+" "+d.getApellidoMaterno());
            		}
            	});
        		
        		especialidades.stream().forEach((e)->{
            		if(c.getIdEspecialidad() == e.getIdEspecialidad()) {
            			p.setEspecialidad(e.getNombreEspecialidad());
            		}
            	});		
        	});
        	
        	alumnos.stream().forEach((a)->{
        		if(p.getUsuario().equals(a.getUsuario())) {
        			p.setAlumno(a.getNombres()+" "+a.getApellidoPaterno()+" "+a.getApellidoMaterno());
        		}
        	});	
        	
        	
	    	if (p.getUsuario().equals(nota.getUsuario())) {
	    		notasUsuario.add(p);
			}
	     });
        
        return new ResponseEntity(notasUsuario, HttpStatus.OK);
    }
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Nota nota){
		banderaCurso = false;
		banderaUsuario = false;
		String respuesta = "";
		List<Curso> cursos = cursoService.obtenerCurso();
		List<Alumno> alumnos = alumnoService.obtenerAlumno();
		
		cursos.stream().forEach((d)->{
    		if(d.getIdCurso() == nota.getIdCurso()) {
    			banderaCurso = true;
    		}
    	});
		
		if (!banderaCurso) {
			respuesta = "Error. Curso no registrado.";
			return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		alumnos.stream().forEach((d)->{
    		if(d.getUsuario().equals(nota.getUsuario())) {
    			banderaUsuario = true;
    		}
    	});
		
		if (!banderaUsuario) {
			respuesta = "Error. Usuario no registrado.";
			return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
		}
		
		respuesta = notaService.registrarNota(nota);
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}
	
}

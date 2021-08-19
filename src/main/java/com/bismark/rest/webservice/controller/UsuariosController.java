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

import com.bismark.rest.webservice.model.User;
import com.bismark.rest.webservice.service.UsuariosService;

@RestController
@RequestMapping("/rest/usuario")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	
	@GetMapping
    public ResponseEntity<User> list() {
        List<User> users = usuariosService.obtenerUsuarios();
        return new ResponseEntity(users, HttpStatus.OK);
    }
	
	@PostMapping
	public ResponseEntity<String> registrarUsuario(@RequestBody User user){
		String respuesta = usuariosService.registrarUsusario(user);
		return new ResponseEntity(respuesta, HttpStatus.OK);
	}
	
}

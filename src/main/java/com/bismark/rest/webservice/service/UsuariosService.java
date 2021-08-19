package com.bismark.rest.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bismark.rest.webservice.dao.UserRepossitory;
import com.bismark.rest.webservice.model.User;

@Service
public class UsuariosService {
	@Autowired
	private UserRepossitory usuariosRepositorio;
	
	public List<User> obtenerUsuarios(){
		return usuariosRepositorio.findAll();
	}
	
	public String registrarUsusario(User user) {
		usuariosRepositorio.save(user);
		return "Usuario registrado con exito";
	}
}

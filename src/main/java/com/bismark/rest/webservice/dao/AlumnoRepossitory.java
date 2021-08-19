package com.bismark.rest.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bismark.rest.webservice.model.Alumno;

public interface AlumnoRepossitory extends JpaRepository<Alumno, Integer>{

}

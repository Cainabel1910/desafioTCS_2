package com.bismark.rest.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bismark.rest.webservice.model.Curso;

public interface CursoRepossitory extends JpaRepository<Curso, Integer>{

}

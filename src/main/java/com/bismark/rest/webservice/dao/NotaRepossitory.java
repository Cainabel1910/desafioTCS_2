package com.bismark.rest.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bismark.rest.webservice.model.Nota;

public interface NotaRepossitory extends JpaRepository<Nota, Integer>{

}

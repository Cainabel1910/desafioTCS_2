package com.bismark.rest.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bismark.rest.webservice.model.User;

public interface UserRepossitory extends JpaRepository<User, String>{
	//User findByUsername(String username);
}

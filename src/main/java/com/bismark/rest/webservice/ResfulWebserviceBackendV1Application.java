package com.bismark.rest.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class ResfulWebserviceBackendV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ResfulWebserviceBackendV1Application.class, args);
	}

}

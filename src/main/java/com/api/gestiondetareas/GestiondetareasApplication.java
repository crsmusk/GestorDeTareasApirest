package com.api.gestiondetareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.gestiondetareas")
public class GestiondetareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiondetareasApplication.class, args);
	}

	

}

package com.eoi.puntuaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PuntuacionesSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuntuacionesSpringApplication.class, args);
	}

	@GetMapping("/hola")
	public String hola() {
		return "Hola mundo";
	}

}

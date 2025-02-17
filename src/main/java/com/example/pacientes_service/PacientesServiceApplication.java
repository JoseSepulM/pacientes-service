package com.example.pacientes_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PacientesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacientesServiceApplication.class, args);
	}

}

package com.ejemplospring.ejemplospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemplospringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(("Ejemplo spring"));
	}
}

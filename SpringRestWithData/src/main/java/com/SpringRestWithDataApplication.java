package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication			
public class SpringRestWithDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestWithDataApplication.class, args);
		System.err.println("Server running on port number 9090");
	}

}

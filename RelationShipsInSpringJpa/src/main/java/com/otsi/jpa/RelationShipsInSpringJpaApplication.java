package com.otsi.jpa;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = { "com.otsi.jpa.*" })
@SpringBootApplication
public class RelationShipsInSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationShipsInSpringJpaApplication.class, args);
	}

}

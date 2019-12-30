package com.otsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.otsi.*" })
@SpringBootApplication
public class ExceptionHandlingInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingInSpringBootApplication.class, args);
	}

}

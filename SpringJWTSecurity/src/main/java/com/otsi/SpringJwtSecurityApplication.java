package com.otsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.otsi.*"})
public class SpringJwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtSecurityApplication.class, args);
	}

}

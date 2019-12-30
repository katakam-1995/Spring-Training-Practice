package com.org.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Configuration
public class TestApplication {
	@Profile("dev")
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}

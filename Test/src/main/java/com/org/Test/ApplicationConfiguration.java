package com.org.Test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public void start() {
		System.out.println("Configured Successfully.........");
	}
}

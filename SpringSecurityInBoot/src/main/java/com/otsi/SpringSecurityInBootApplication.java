package com.otsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.otsi.repository.SpringSecurityRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {SpringSecurityRepository.class})
public class SpringSecurityInBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityInBootApplication.class, args);
	}

}

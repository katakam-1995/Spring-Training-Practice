package com.couchbase;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.web.client.RestTemplate;

//@EnableCouchbaseRepositories(basePackages = {"com.couchbase.*" })
@SpringBootApplication
@EnableCouchbaseRepositories
@Configuration
public class CouchBaseSpringConnectionApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(3000)).setReadTimeout(Duration.ofMillis(3000)).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CouchBaseSpringConnectionApplication.class, args);
	}

}

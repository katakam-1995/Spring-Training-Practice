package com.couchbase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.couchbase.client.core.message.config.FlushResponse;
import com.couchbase.model.Student;
import com.couchbase.repository.CouchBaseRepository;

@RestController
public class StudentController {
	
	@Autowired
    private RestTemplate restTemplate;

	@Autowired
	CouchBaseRepository couchBaseRepository;

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student newStudent) {
		return couchBaseRepository.save(newStudent);
	}

	@GetMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable String id) {
		if (couchBaseRepository.existsById(id)) {
			return couchBaseRepository.findById(id);
		} else
			return Optional.empty();
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return couchBaseRepository.findAll();
	}
	
	@GetMapping(value="/getAndSaveEmployeeDetailsInCouchBase")
	public  void getAndSaveEmployeeDetailsInCouchBase() {
		
		String url="http://localhost:8080/students/{id}";
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	
		HttpEntity requestEntity = new HttpEntity<>(headers);

		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
	                .queryParam("id", "1");
		ResponseEntity responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("response received");
            System.out.println(responseEntity.getBody());
        } else {
            System.out.println("error occurred");
            System.out.println(responseEntity.getStatusCode());
        }
		
	}
}

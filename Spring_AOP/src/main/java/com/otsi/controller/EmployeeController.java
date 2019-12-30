package com.otsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.otsi.exception.ResourceNotFoundException;
import com.otsi.model.EmployeeVO;
import com.otsi.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empServiceImpl;
	
	@Autowired
    private RestTemplate restTemplate;

	@RequestMapping("/data")
	public String getInfo() {
		System.out.println("Getting Information using spring AOP Concept......");
		return "hello";
	}

	@PostMapping(value = "/saveEmployeeDetails")
	public ResponseEntity<List<EmployeeVO>> saveEmployeeDetails(@RequestBody List<EmployeeVO> empVo) throws Exception {
		if (!empVo.isEmpty()) {
			List<EmployeeVO> employeeDetails = empServiceImpl.saveEmployeeDetails(empVo);
			return ResponseEntity.status(HttpStatus.OK).body(employeeDetails);
		}
		throw new ResourceNotFoundException("No Input Found");
	}
	
	@GetMapping(value="/getAndSaveEmployeeDetailsInCouchBase")
	public void getAndSaveEmployeeDetailsInCouchBase() {
		
		String url="http://localhost:8000/students/10";
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
	
		HttpEntity requestEntity = new HttpEntity<>(headers);

	//	UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)  .queryParam("id", 1);
		ResponseEntity responseEntity = restTemplate.exchange(
				url.toString(),
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

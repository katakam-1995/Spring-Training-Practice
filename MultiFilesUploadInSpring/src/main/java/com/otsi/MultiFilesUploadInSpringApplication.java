package com.otsi;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.otsi.controller.EmployeeController;

@SpringBootApplication
public class MultiFilesUploadInSpringApplication {

	public static void main(String[] args) {
		new File(EmployeeController.uploadingDir).mkdirs();
		SpringApplication.run(MultiFilesUploadInSpringApplication.class, args);
		
	}
	
}

package com.otsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.otsi.model.Employee;
import com.otsi.repository.EmployeeRepository;

@Controller
public class UserController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/addUser")
	public String addUser(Model model) {
		List<Employee> employees=employeeRepository.findAll();
//		List<Employee> employees=null;
		model.addAttribute("employees", employees);
		return "index";
	}

}

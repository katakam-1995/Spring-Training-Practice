package com.otsi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	public String getString() {
		return "<h1>Welcome To Spring Security</h1>";
	}
	
	@GetMapping("/admin")
	public String getAdminString() {
		return "<h1>Welcome To Admin Page</h1>";
	}
	
	@GetMapping("/user")
	public String getUserString() {
		return "<h1>Welcome To User Page</h1>";
	}

	@GetMapping("/getUserNameFromDB")
	public String getUserNameFromDB() {
		return "<h1>Welcome To Spring Security</h1>";
	}
}

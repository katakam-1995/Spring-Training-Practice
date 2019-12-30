package com.otsi.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {
	  @GetMapping("/hello")
	    public String example() {
	        return "Hello....!! \n Today's Date Is:: " + new Date();
	    }
}

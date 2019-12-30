package com.org.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class TestController {

	@GetMapping("/data")
	public String getInfo(@RequestParam String name) {
		return name;
	}

}

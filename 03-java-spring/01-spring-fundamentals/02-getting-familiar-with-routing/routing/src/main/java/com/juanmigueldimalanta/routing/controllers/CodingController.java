package com.juanmigueldimalanta.routing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String home() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String awesome() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String better() {
		return "Java/Spring is better!";
	}
}

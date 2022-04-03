package com.juanmigueldimalanta.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	@RequestMapping("")
	public String greeting() {
		return "The dojo is awesome!";
	}
	@RequestMapping("/{name}")
	public String location(@PathVariable("name") String locationName) {
		return locationName + " Dojo is located in Southern California.";
	}
	@RequestMapping("san-jose")
	public String headquarters() {
		return "SJ dojo is the headquarters.";
	}
}

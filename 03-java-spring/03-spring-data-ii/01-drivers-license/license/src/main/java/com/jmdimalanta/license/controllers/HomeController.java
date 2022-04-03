package com.jmdimalanta.license.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jmdimalanta.license.models.License;
import com.jmdimalanta.license.models.Person;
import com.jmdimalanta.license.services.LicenseService;
import com.jmdimalanta.license.services.PersonService;

@Controller
public class HomeController {
	@Autowired
	private PersonService pService;
	
	@Autowired
	private LicenseService lService;
	//Home page
	@GetMapping("/")
	public String index(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	//Add a person
	@PostMapping("/create")
	public String create(@ModelAttribute("person") Person person) {
		pService.createPerson(person);
		return "redirect:/dash";
	}
	//display all people
	@GetMapping("/dash")
	public String newLicense(@ModelAttribute("newLicense") License license, Model model) {
		List<Person> allPersons = this.pService.allPersons();
		model.addAttribute("allPersons", allPersons);
		return "newlicense.jsp";
	}
	
	@PostMapping("/license/create")
	public String createLicense(@ModelAttribute("newlicense") License license) {
		lService.createLicense(license);
		return "redirect:/result/{id}";
	}
	
	@GetMapping("/result/{id}")
	public String showInfo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", pService.findPerson(id));
		return "showlicense.jsp";
	}
	
}

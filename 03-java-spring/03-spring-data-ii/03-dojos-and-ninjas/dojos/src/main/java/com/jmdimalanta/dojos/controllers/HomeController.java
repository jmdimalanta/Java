package com.jmdimalanta.dojos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jmdimalanta.dojos.models.Dojo;
import com.jmdimalanta.dojos.services.DojoService;
import com.jmdimalanta.dojos.services.NinjaService;

@Controller
public class HomeController {
	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	//Home Page
	@GetMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	//create a dojo
	@PostMapping("/create")
	public String create(@ModelAttribute("dojo") Dojo dojo) {
		dService.createDojo(dojo);
		return "redirect:/dash";
	}
	//display all dojos
	@GetMapping("/dash")
	public String allDojos(Model model) {
		List<Dojo> dojos = dService.allDojos();
		model.addAttribute("dojos", dojos);
		return "Dashboard.jsp";
	}
	//display all ninjas in the dojo
	@GetMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dService.findDojo(id));
		return "info.jsp";
	}
}

package com.jmdimalanta.dojos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jmdimalanta.dojos.models.Dojo;
import com.jmdimalanta.dojos.models.Ninja;
import com.jmdimalanta.dojos.services.DojoService;
import com.jmdimalanta.dojos.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private DojoService dService;
	
	@Autowired
	private NinjaService nService;
	
	//Add a new ninja
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		List<Dojo> allDojos= this.dService.allDojos();
			model.addAttribute("allDojos", allDojos);
			return "new.jsp";
	}
	
	@PostMapping("/ninja/create")
	public String createNinja(@ModelAttribute("newNinja") Ninja ninja) {
		this.nService.createNinja(ninja);
		return "redirect:/dash";
	}
}

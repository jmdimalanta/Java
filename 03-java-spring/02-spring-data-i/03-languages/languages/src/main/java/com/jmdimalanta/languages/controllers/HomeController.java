package com.jmdimalanta.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jmdimalanta.languages.models.Language;
import com.jmdimalanta.languages.services.LanguageService;

@Controller
public class HomeController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("language") Language language) {
		return "index.jsp";
	}
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			Language newLanguage = lService.createLanguage(language);
			return "redirect:/dash";
		}
	}
	@GetMapping("/dash")
	public String allLanguages(Model model) {
		List<Language> languages = lService.allLanguages();
		model.addAttribute("languages", languages);
		return "dashboard.jsp";
	}
	@DeleteMapping("/delete/languages/{id}")
	private String deleteLanguage(@PathVariable("id") Long id) {
		lService.deleteLanguage(id);
		return "redirect:/dash";
	}
	@GetMapping("/show/{id}")
	private String getOneLanguage(@PathVariable("id") Long id, Model model) {
		Language language = this.lService.findLanguage(id);
		model.addAttribute("language", language);
		return "view.jsp";
	}
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = this.lService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			lService.updateLanguage(language);
			return "redirect:/dash";
		}
	}
}

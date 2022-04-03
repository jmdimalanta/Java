package com.jmdimalanta.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jmdimalanta.authentication.models.User;
import com.jmdimalanta.authentication.services.UserService;
import com.jmdimalanta.authentication.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private UserValidator validators;
	
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		//Email/password validation
		validators.validate(user, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			User newUser= uService.registerUser(user);
			session.setAttribute("userId", newUser.getId());
			return "redirect:/";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	//if user is authenticated, save the user id in session
	if(uService.authenticateUser(email, password)) {
		User user = uService.findByEmail(email);
		session.setAttribute("userId", user.getId());
		return "redirect:/dash";
		
	}
	//else, add error messages and return to the login page
	redirectAttributes.addFlashAttribute("error", "Invalid Email or Password!");
	return "redirect:/";
	}
	
	@GetMapping("/dash")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") != null) {
			User user = uService.findUserByID((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			return "dashboard.jsp";
		}
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//invalidating session
		session.invalidate();
		//redirect to login
		return "redirect:/";
	}
}

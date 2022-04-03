package com.jmdimalanta.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat ("E, dd MMMM yyyy");
		String myDate = formatter.format(date);
		model.addAttribute("date", myDate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model2) {
		model2.addAttribute("time", LocalDateTime.now());
		return "time.jsp";
	}
}

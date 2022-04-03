package com.jmdimalanta.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
					currentCount ++;
					session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}
	@RequestMapping("/your_server/counter")
	public String addCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("showCount",currentCount);
		return "counter.jsp";			
	}
	@RequestMapping("/counterbytwo")
	public String doubleCount(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount +=1;
			session.setAttribute("count", currentCount);
		}
		return "doublecount.jsp";
	}
	@RequestMapping("/reset")
	public String destroy(HttpSession session) {
		if (session.getAttribute("count") != null) {
			session.setAttribute("count", 0);
		}
		return "index.jsp";
	}
	
}

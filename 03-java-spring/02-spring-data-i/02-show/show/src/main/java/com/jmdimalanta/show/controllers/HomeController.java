package com.jmdimalanta.show.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jmdimalanta.show.models.Book;
import com.jmdimalanta.show.services.BookService;

@Controller
public class HomeController {
	@Autowired
	private BookService bService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("book") Book book) {
		return "index.jsp";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute("book") Book book) {
		Book newBook = bService.createBook(book);
		return "redirect:/dash";
	}
	@GetMapping("/dash")
	public String allBooks(Model model) {
		List<Book> books = bService.allBooks();
		model.addAttribute("books", books);
		return "Dashboard.jsp";
	}
	@GetMapping("/show/{id}")
	private String getOneBook(@PathVariable("id") Long id, Model model) {
		Book book = this.bService.findBook(id);
		model.addAttribute("book", book);
		return "view.jsp";
	}
}

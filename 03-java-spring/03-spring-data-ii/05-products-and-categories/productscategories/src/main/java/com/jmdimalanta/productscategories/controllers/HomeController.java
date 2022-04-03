package com.jmdimalanta.productscategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jmdimalanta.productscategories.models.Category;
import com.jmdimalanta.productscategories.models.Product;
import com.jmdimalanta.productscategories.services.CategoryService;
import com.jmdimalanta.productscategories.services.ProductService;


@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	
	@Autowired CategoryService cService;
	
	@GetMapping ("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "index.jsp";
	}
	
	@PostMapping ("/products/create")
	public String createProduct(@ModelAttribute("product")Product product) {
		pService.createProduct(product);
		return "redirect:/categories/new";
	}
	
	@GetMapping ("/categories/new")
	public String newCategory(@ModelAttribute("category")Category category) {
		return "newcategory.jsp";
	}
	
	@PostMapping("/categories/create")
	public String createCategory(@ModelAttribute("category")Category category) {
		cService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		Product product = this.pService.findProduct(id);
		model.addAttribute("notInProd", this.cService.someCategory(product));
		model.addAttribute("product", product);
		return "showProduct.jsp";
	}
	
	@PostMapping("/addCatToProd/{id}")
	public String addCatToProd(@RequestParam("categories") Long id, @PathVariable("id") Long productId) {
		Product productToAddCat = this.pService.findProduct(productId);
		Category categoryToAdd = this.cService.findCategory(id);
		this.pService.addCategoryToProduct(productToAddCat, categoryToAdd);
		return "redirect:/products/{id}";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(Model model, @PathVariable("id") Long id) {
		Category category = this.cService.findCategory(id);
		model.addAttribute("notInCat", this.pService.someProduct(category));
		model.addAttribute("category", category);
		return "showCategory.jsp";
	}
	
	@PostMapping("/addProdToCat/{id}")
	public String addProdToCat(@RequestParam("products") Long id, @PathVariable("id") Long categoryId) {
		Category categoryToAddProd = this.cService.findCategory(id);
		Product productToAdd = this.pService.findProduct(categoryId);
		this.cService.addProductToCategory(productToAdd, categoryToAddProd);
		return "redirect:/categories/{id}";
	}
	
}

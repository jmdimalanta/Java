package com.jmdimalanta.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdimalanta.productscategories.models.Category;
import com.jmdimalanta.productscategories.models.Product;
import com.jmdimalanta.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public List<Category> allCategories(){
		return cRepo.findAll();
	}
	
	public Category createCategory (Category c) {
		return this.cRepo.save(c);
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = cRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public Category addProducts (Product p, Category c) {
		List<Product> myProducts = c.getProducts();
		myProducts.add(p);
		return cRepo.save(c);
	}
	
	public List<Category> someCategory(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
	
	public void addProductToCategory(Product product, Category category) {
		List<Product> existingProducts = category.getProducts();
		existingProducts.add(product);
		this.cRepo.save(category);
	}
}

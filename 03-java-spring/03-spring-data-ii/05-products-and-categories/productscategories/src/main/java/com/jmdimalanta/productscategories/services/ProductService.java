package com.jmdimalanta.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdimalanta.productscategories.models.Category;
import com.jmdimalanta.productscategories.models.Product;
import com.jmdimalanta.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public List<Product> allProducts(){
		return pRepo.findAll();
	}
	
	public Product createProduct (Product p) {
		return this.pRepo.save(p);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = pRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Product addCategories (Product p, Category c) {
		List<Category> myCategories = p.getCategories();
		myCategories.add(c);
		return pRepo.save(p);
	}
	
	public List<Product> someProduct(Category category){
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> existingCategories = product.getCategories();
		existingCategories.add(category);
		this.pRepo.save(product);
	}
	
}

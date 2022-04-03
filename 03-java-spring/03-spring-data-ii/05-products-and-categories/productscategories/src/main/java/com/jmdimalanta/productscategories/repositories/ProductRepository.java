package com.jmdimalanta.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jmdimalanta.productscategories.models.Category;
import com.jmdimalanta.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category category);
}

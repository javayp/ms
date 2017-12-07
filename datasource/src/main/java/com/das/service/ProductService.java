package com.das.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.model.Product;
import com.das.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public void createProduct(Product product) {
		productRepo.save(product);
	}

	public List<Product> getAllProductList() {
		return productRepo.findAll();
	}

	public Product findProductById(int id) {
		return productRepo.findOne(id);
	}

	public void deleteProductById(int id) {
		productRepo.delete(id);
	}

	public void updateProduct(int id,Product product) {
		
		productRepo.save(Product.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build());
		
	}
	
}

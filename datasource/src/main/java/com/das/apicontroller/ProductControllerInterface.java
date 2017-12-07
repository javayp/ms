package com.das.apicontroller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.das.model.Product;
import com.das.util.Status;

public interface ProductControllerInterface {

	Status create(Product product);

	List<Product> readProductList();

	ResponseEntity<?> readProductById(int id);

	Status updateProduct(int id, Product product);

	Status deleteProductById(int id);

}
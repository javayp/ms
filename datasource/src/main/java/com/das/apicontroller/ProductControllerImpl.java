package com.das.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.das.model.Product;
import com.das.service.ProductService;
import com.das.util.Status;

@RestController
public class ProductControllerImpl implements ProductControllerInterface {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/message")
	public String message() {
		return "string message";
	}
	
	@Override
	@CrossOrigin
	@PostMapping("/create")
	public Status create(@RequestBody Product product) {
		productService.createProduct(product);
		return Status.builder().statusCode(HttpStatus.CREATED.value()).message("PRODUCT CREATED").build();
	}

	@Override
	@GetMapping("/read")
	public List<Product> readProductList(){
		return productService.getAllProductList();
	}


	@Override
	@GetMapping(value="/read/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readProductById(@PathVariable int id) {
		if(productService.findProductById(id)!=null) {			
			return new ResponseEntity<Product>(productService.findProductById(id),HttpStatus.OK);		
		}else {
			return new ResponseEntity<Status>(new Status(HttpStatus.NOT_FOUND.value(),"NOT FOUND"),HttpStatus.NOT_FOUND);
		}
	}


	@Override
	@PutMapping(value="/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public Status updateProduct(@PathVariable int id,@RequestBody Product product) {
		if(product.getId()==id) {			
			productService.updateProduct(id,product);
			return Status.builder().statusCode(HttpStatus.OK.value()).message("PRODUCT UPDATED").build();
		}else {
			return Status.builder().statusCode(HttpStatus.NOT_FOUND.value()).message("PRODUCT ID NOT FOUND").build();
		}
	}


	@Override
	@DeleteMapping("/delete/{id}")
	public Status deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
		return Status.builder().statusCode(HttpStatus.OK.value()).message("PRODUCT DELETED").build();
	}
}

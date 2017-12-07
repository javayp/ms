package com.das.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.das.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}

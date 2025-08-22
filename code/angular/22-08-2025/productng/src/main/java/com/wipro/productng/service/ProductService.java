package com.wipro.productng.service;

import java.util.List;

import com.wipro.productng.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	Product findById(int id);
	void save(Product product);
	void delete(int id);
}

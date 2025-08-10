package com.wipro.productman.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.productman.entity.ProductManagement;

public interface ProductService {
	
	void save(ProductManagement pm);
	List<ProductManagement> findAll();
	ProductManagement findById(int id);
	void deleteById(int id);
	List<ProductManagement> findByproductMakeAndProductNameOrderByProductNameDesc(String productMake,String productName);
	Page<ProductManagement> findAll(Pageable p);
}

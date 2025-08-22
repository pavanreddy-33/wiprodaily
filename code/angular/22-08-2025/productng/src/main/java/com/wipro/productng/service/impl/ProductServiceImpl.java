package com.wipro.productng.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.productng.entity.Product;
import com.wipro.productng.repo.ProductRepo;
import com.wipro.productng.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product findById(int id) {
		Optional<Product> op = productRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public void save(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}
	

}

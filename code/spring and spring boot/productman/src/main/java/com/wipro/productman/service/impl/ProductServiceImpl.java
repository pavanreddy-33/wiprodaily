package com.wipro.productman.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.productman.entity.ProductManagement;
import com.wipro.productman.repo.ProductRepo;
import com.wipro.productman.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void save(ProductManagement pm) {
		productRepo.save(pm);

	}

	@Override
	public List<ProductManagement> findAll() {
		return productRepo.findAll();
	}

	@Override
	public ProductManagement findById(int id) {
		Optional<ProductManagement> pm = productRepo.findById(id);
		if(!pm.isEmpty()) {
			return pm.get();
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		productRepo.deleteById(id);

	}

	@Override
	public List<ProductManagement> findByproductMakeAndProductNameOrderByProductNameDesc(String productMake,String productName) {
		return productRepo.findByproductMakeAndProductNameOrderByProductNameDesc(productMake,productName);
	}

	@Override
	public Page<ProductManagement> findAll(Pageable p) {
		return productRepo.findAll(p);
	}

}

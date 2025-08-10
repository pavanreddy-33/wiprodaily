package com.wipro.productman.repo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productman.entity.ProductManagement;

@Repository
public interface ProductRepo extends JpaRepository<ProductManagement, Integer> {
	
	List<ProductManagement> findByproductMakeAndProductNameOrderByProductNameDesc(String productMake,String productName);
	
	Page<ProductManagement> findAll(Pageable p);
}

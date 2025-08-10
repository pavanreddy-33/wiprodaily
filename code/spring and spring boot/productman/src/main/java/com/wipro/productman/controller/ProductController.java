package com.wipro.productman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.wipro.productman.entity.ProductManagement;
import com.wipro.productman.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Operation(summary = "Save a product")
	  @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Saved successfully"),
	    @ApiResponse(responseCode = "404", description = "Not found")
	  })
	@PostMapping
	void save(@RequestBody ProductManagement pm) {
		productService.save(pm);
	}
	
	@GetMapping
	List<ProductManagement> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	ProductManagement findById(@PathVariable int id) {
		return productService.findById(id);
	}
	
	@PutMapping
	void update(@RequestBody ProductManagement pm) {
		productService.save(pm);
	}
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id) {
		productService.deleteById(id);
	}
	
	@GetMapping("/type")
	public List<ProductManagement> findByproductMakeAndProductNameOrderByProductNameDesc(@RequestParam String productMake,@RequestParam String productName) {
		return productService.findByproductMakeAndProductNameOrderByProductNameDesc(productMake,productName);
	}
	
	@GetMapping("/typepath/{path}/{path2}")
	public List<ProductManagement> findByproductMakePath(@PathVariable String path,@PathVariable String path2) {
		return productService.findByproductMakeAndProductNameOrderByProductNameDesc(path,path2);
	}
	
	@GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
	public Page<ProductManagement> findAllPage(@PathVariable int pageNum,@PathVariable int pageSize,@PathVariable int sortOrder) {
		Pageable p=null;
		if(sortOrder==0) {
			p=PageRequest.of(pageNum,pageSize,Sort.by("productPrice").descending());
		}else {
			p=PageRequest.of(pageNum,pageSize,Sort.by("productPrice").ascending());
		}
		return productService.findAll(p);
	}
}

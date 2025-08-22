package com.wipro.productng.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.productng.entity.Order;
import com.wipro.productng.entity.Product;
import com.wipro.productng.repo.OrderRepo;
import com.wipro.productng.repo.ProductRepo;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class orderController {
	
	@Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @PostMapping("/place/{productId}")
    public ResponseEntity<?> placeOrder(@PathVariable int id, @RequestParam int qty) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < qty) {
            return ResponseEntity.badRequest().body("Not enough stock available!");
        }

        // reduce qty
        product.setQuantity(product.getQuantity() - qty);
        productRepo.save(product);

        // save order
        Order order = new Order();
        order.setProductName(product.getName());
        order.setQtyPurchased(qty);
        order.setOrderDate(LocalDateTime.now());
        orderRepo.save(order);

        return ResponseEntity.ok(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }
}

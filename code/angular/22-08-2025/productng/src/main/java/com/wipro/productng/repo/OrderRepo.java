package com.wipro.productng.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productng.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

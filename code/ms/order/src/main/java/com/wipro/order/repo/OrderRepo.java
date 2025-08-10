package com.wipro.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.order.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

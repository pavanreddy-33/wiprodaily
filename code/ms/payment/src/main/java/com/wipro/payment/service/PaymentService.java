package com.wipro.payment.service;

import java.util.List;

import com.wipro.payment.entity.Payment;

public interface PaymentService {
	
	void save(Payment order);
	List<Payment> findAll();
}

package com.wipro.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="orderms")
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="order_number")
	String orderNumber;
	
	@Column(name="order_value")
	double orderValue;
	
	@Column(name="order_status")
	String orderStatus;
}

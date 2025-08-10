package com.example.user.dto;

public class Mobile {
	
	String make;
	String modelNumber;
	int price;
	int id;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Mobile [make=" + make + ", modelNumber=" + modelNumber + ", price=" + price + ", id=" + id + "]";
	}
	
	
	
}

package com.wipro.oop;

public class Restaurant {
	String restName;
	String address;
	int phNo;
	public Restaurant(String restName, String address, int phNo) {
		this.restName = restName;
		this.address = address;
		this.phNo = phNo;
	}
	
	
	
	public void print() {
		System.out.println(restName);
        System.out.println( address);
        System.out.println( phNo);
		
	}

}

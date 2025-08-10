package com.wipro.java;

public class anonymous {

	public static void main(String[] args) {
		BanKops sA = new BanKops() {
            double balance = 0;
            public void deposit(double amount) {
                balance += amount;
                System.out.println(balance);
            }
        };
        BanKops cA = new BanKops() {
            double balance = 0;

            
            public void deposit(double amount) {
                balance += amount;
                System.out.println(balance);
            }
        };

        
        sA.deposit(5000);
        cA.deposit(10000);

	}

}

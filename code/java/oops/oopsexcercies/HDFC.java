package com.wipro.oop;

public class HDFC implements BankOps {
    private String accNumber;
    private double balance;

    public HDFC(String accNumber) {
        this.accNumber = accNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount, String accNumber) {
        if (this.accNumber.equals(accNumber)) {
            balance += amount;
            System.out.println("HDFC: Deposited " + amount + " to account " + accNumber);
        } else {
            System.out.println("Invalid account number.");
        }
    }
    public double getBalance(String accNumber) {
        if (this.accNumber.equals(accNumber)) {
            return balance;
        } else {
            System.out.println("HDFC: Invalid account number.");
            return -1;
        }
    }
}

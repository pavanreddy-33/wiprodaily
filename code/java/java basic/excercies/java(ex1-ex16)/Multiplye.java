package com.wipro.java;

public class Multiplye {
    public static void main(String[] args) {
    
        Multiply mul = (a, b) -> a * b;

        int res = mul.multiply(58, 90);

        System.out.println(res);
    }
}
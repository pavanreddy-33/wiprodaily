package com.wipro.oop;


public class TestConvertor {
 public static void main(String[] args) {
     Converter obj = new Converter();
     int square = obj.convert(5);
     System.out.println("Square of 5: " + square);
     int sum = obj.convert(4, 6);
     System.out.println("Sum : " + sum);
     double half = obj.convert(8.4);
     System.out.println("Half " + half);
 }
}


package com.wipro.day4;

public class TestBox {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.add(42);
        System.out.println(intBox.get());
        Box<String> strBox = new Box<>();
        strBox.add("Wipro");
        System.out.println(strBox.get());
        Box<Double> doubleBox = new Box<>();
        doubleBox.add(99.99);
        System.out.println(doubleBox.get());
    }
}

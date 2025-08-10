package com.wipro.oop;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void makeSound() {
        System.out.println(name + " barks.");
    }
    public void move() {
        System.out.println(name + " runs on four legs.");
    }
}

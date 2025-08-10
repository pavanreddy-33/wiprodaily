package com.wipro.oop;

public class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps.");
    }
    public void move() {
        System.out.println(name + " flies in the sky.");
    }
}

package com.wipro.oop;

public abstract class Animal {
    String name;
    

    public Animal(String name) {
        this.name = name;
        
    }
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public abstract void makeSound();

    public abstract void move();
}

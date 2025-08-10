package com.wipro.oop;

public class AnimalTest {
    public static void main(String[] args) {
        Animal human = new Human("chandu");
        Animal bird = new Bird("Sparrow");
        Animal dog = new Dog("Bruno");
        human.eat();
        human.sleep();
        human.makeSound();
        human.move();
        bird.eat();
        bird.sleep();
        bird.makeSound();
        bird.move();
        dog.eat();
        dog.sleep();
        dog.makeSound();
        dog.move();
    }
}

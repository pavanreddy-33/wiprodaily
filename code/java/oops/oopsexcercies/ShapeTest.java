package com.wipro.oop;

public class ShapeTest {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5.5);
        Rectangle rectangle = new Rectangle("Blue", 4.0, 6.0);
        Square square = new Square("Green", 4.5);

        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);
    }
}

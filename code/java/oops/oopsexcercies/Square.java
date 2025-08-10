package com.wipro.oop;

public class Square extends Shape {
    double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public String toString() {
        return "Square [Color=" + getColor() + ", Side=" + side + "]";
    }
}

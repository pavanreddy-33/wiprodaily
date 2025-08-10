package com.wipro.oop.use;

import com.wipro.oop.Restaurant;

public class MainApp {
    public static void main(String[] args) {
        Restaurant rest = new Restaurant("Spice Garden", "Bangalore", 987654321);
        rest.print();
    }
}

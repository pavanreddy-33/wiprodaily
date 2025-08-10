package com.wipro.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<FoodItem> foodList = Arrays.asList(
            new FoodItem("Spring Rolls", "Veg", "Chinese", 120.0),
            new FoodItem("Fried Rice", "Veg", "Chinese", 150.0),
            new FoodItem("Kung Pao Chicken", "Non Veg", "Chinese", 250.0),
            new FoodItem("Pad Thai", "Non Veg", "Thai", 220.0),
            new FoodItem("Pasta Alfredo", "Veg", "Continental", 200.0),
            new FoodItem("Green Curry", "Veg", "Thai", 180.0)
        );
        List<FoodItem> chineseFoods = foodList.stream()
                .filter(item -> item.cuisine.equalsIgnoreCase("Chinese"))
                .collect(Collectors.toList());
        for (FoodItem item : chineseFoods) {
            System.out.println(item);
        }
        System.out.println("most expensive Chinese dish ");
        foodList.stream()
        .filter(item -> item.cuisine.equalsIgnoreCase("Chinese"))
        .max(Comparator.comparingDouble(item -> item.price))
        .ifPresent(System.out::println);
}
    }

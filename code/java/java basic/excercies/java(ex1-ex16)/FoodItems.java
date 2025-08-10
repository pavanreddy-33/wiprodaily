package com.wipro.java;

class FoodItem {
    String foodName;
    String foodType;  
    String cuisine;   
    double price;
    public FoodItem(String foodName, String foodType, String cuisine, double price) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.cuisine = cuisine;
        this.price = price;
    }
    @Override
    public String toString() {
        return foodName + " (" + foodType + ", " + cuisine + ") - ₹" + price;
    }
}
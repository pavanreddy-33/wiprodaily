package com.wipro.day4;

import java.util.Map;
import java.util.TreeMap;

public class CurrencyMapSort {
    public static void main(String[] args) {
        Map<String, String> currencyMap = new TreeMap<>();
        currencyMap.put("INR", "Indian Rupee");
        currencyMap.put("USD", "United States Dollar");
        currencyMap.put("EUR", "Euro");
        currencyMap.put("JPY", "Japanese Yen");
        currencyMap.put("GBP", "British Pound");
        for (Map.Entry<String, String> entry : currencyMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

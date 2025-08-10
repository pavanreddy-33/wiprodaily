package com.wipro.day4;
import java.util.*;
public class RemoveDuplicates {

	

	    public static void main(String[] args) {
	        List<Integer> numbers = new ArrayList<>();
	        numbers.add(10);
	        numbers.add(20);
	        numbers.add(10);
	        numbers.add(30);
	        numbers.add(20);
	        System.out.println("Original List: " + numbers);
	        Set<Integer> uniqueNumbers = new LinkedHashSet<>(numbers);
	        List<Integer> result = new ArrayList<>(uniqueNumbers);
	        System.out.println("List after removing duplicates: " + result);
	    
	}

}

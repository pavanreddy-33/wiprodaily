package com.wipro.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiDemo {

	public static void main(String[] args) {
//		List<String> names = Arrays.asList("jayanta", "jnanedra", "raja", "ajay", "jaya", "jatin");
//		
//		List<String> res = names.stream()
//                .filter(name -> name.contains("ja"))
//                .peek(name -> System.out.println("Passing name: " + name))
//                
//                .collect(Collectors.toList());
//		System.out.println(res);
//		
		//average
		List<Integer> numbers = Arrays.asList(15, 25, 35, 45, 55);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
                int count = numbers.size();
                System.out.println(sum/count);
		

	}

}

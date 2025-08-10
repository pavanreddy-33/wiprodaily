package com.wipro.java;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Functional {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> {
			return s.length();
			};
			int len = f.apply("cahndu");
			System.out.println(len);
			
			
			List<Integer> li = Arrays.asList(2,4,6,7,3,7,6);
			Function<List<Integer>,Integer> Num = Dsum ->{
				int sum = 0;
				for(int n:li) {
					sum = sum + n;
					
				}
				return sum;
				
				
		};
		int sumVal=Num.apply(li);
		System.out.println(sumVal);
		
		Function<Double,Double> floor = n -> {return n - Math.floor(n);};
		Double res = floor.apply(45.78);
		double rounded = Math.round(res * 100.0) / 100.0;
		System.out.println(rounded);
		
//		list length(Strings) calculator
		
		List<String> names = Arrays.asList("Jayanta", "Amit", "Vasu");
		Function<List<String>, List<Integer>> getLengths = list -> {
			
            ArrayList<Integer> result = new ArrayList<>();
            for (String s : list) {
                result.add(s.length());
            }
            return result;
        };

        List<Integer> lengths = getLengths.apply(names);
        System.out.println(lengths);
			
	}

}

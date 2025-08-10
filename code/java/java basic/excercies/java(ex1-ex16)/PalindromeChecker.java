package com.wipro.java;

import java.util.function.Predicate;

public class PalindromeChecker {

	public static void main(String[] args) {
		String input = "Level";

        Predicate<String> isPalindrome = str -> {
            String reversed = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed += str.charAt(i);
            }
            return str.equalsIgnoreCase(reversed);
        };

        if (isPalindrome.test(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

	}
}

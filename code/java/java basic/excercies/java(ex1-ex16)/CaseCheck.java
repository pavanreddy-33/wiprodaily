package com.wipro.java;

import java.util.function.Predicate;

public class CaseCheck {

	public static void main(String[] args) {
		String input = "helloworld";

        Predicate<String> isUpperCase = str -> str.equals(str.toUpperCase());
        Predicate<String> isLowerCase = str -> str.equals(str.toLowerCase());

        if (isUpperCase.test(input)) {
            System.out.println(input + " is in UPPERCASE.");
        } else if (isLowerCase.test(input)) {
            System.out.println(input + " is in lowercase.");
        } else {
            System.out.println("no");
        }
	}

}

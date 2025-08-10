package com.wipro.java;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Supplier;

public class TommorowDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter:");
        String inputDay = sc.nextLine().toUpperCase();

        String[] validDays = { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", 
                               "FRIDAY", "SATURDAY", "SUNDAY" };

        boolean isValid = Arrays.asList(validDays).contains(inputDay);

        if (isValid) {
            DayOfWeek today = DayOfWeek.valueOf(inputDay);

            Supplier<String> getTomorrow = () -> 
                today.plus(1).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

            System.out.println("Tomorrow is: " + getTomorrow.get());
        } 


    }
}

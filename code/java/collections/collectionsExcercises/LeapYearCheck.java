package com.wipro.day4;

import java.time.LocalDate;

public class LeapYearCheck {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2020-08-14");
        int year = date.getYear();

        if (isLeapYear(year)) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is NOT a Leap Year");
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

package com.wipro.day4;

import java.time.LocalDate;
import java.util.Scanner;

public class DateDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate d1 = LocalDate.parse(sc.nextLine());
        LocalDate d2 = LocalDate.parse(sc.nextLine());
        getDateDiff(d1, d2);
    }

    public static void getDateDiff(LocalDate dt1, LocalDate dt2) {
        if (dt1.isAfter(dt2)) {
            LocalDate temp = dt1;
            dt1 = dt2;
            dt2 = temp;
        }

        int years = dt2.getYear() - dt1.getYear();
        int months = dt2.getMonthValue() - dt1.getMonthValue();
        int days = dt2.getDayOfMonth() - dt1.getDayOfMonth();

        if (days < 0) {
            months--;
            days += dt1.plusMonths(months + 1).minusDays(1).lengthOfMonth();
        }

        if (months < 0) {
            years--;
            months += 12;
        }

        System.out.println(years + " years " + months + " months " + days + " days");

        if (dt2.getMonthValue() == 2 && dt2.getDayOfMonth() == 29) {
            System.out.println("The second date is a Leap Day (Feb 29).");
        } else {
            System.out.println("The second date is NOT a Leap Day.");
        }
    }
}

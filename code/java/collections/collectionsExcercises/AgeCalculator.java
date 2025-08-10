package com.wipro.day4;

import java.time.LocalDate;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        System.out.println(getAge(birthDate));
    }

    public static int getAge(LocalDate dt) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dt.getYear();
        if (today.getDayOfYear() < dt.getDayOfYear()) {
            age--;
        }
        return age;
    }
}

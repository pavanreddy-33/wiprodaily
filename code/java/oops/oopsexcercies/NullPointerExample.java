package com.wipro.oop;
import java.util.*;
public class NullPointerExample {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String Name = s.nextLine();
        try {
            String upperCaseName = Name.toUpperCase();
            System.out.println(upperCaseName);
        } catch (NullPointerException e) {
            
            System.out.println("Caught a NullPointerException: fName is null");
        }
    }
}


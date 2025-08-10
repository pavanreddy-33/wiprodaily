package com.wipro.day4;
import java.util.HashSet;
import java.util.Set;

public class SetsDiff {
    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        setA.add(10);
        setA.add(20);
        setA.add(30);
        setA.add(40);
        setA.add(50);
        Set<Integer> setB = new HashSet<>();
        setB.add(30);
        setB.add(40);
        setB.add(60);
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);

        System.out.println("Difference (A - B): " + difference);
    }
}

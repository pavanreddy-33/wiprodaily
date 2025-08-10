package com.wipro.day4;
import java.util.ArrayList;
public class ArrayL {
	public static void main(String[] args) {
	ArrayList<Integer> li = new ArrayList<>();
	li.add(5);
	li.add(3);
	li.add(2);
	li.add(1);
	li.add(7);
	System.out.println(li);
	li.remove(2);
	System.out.println(li);
	li.add(9);
	System.out.println(li);
	}
}

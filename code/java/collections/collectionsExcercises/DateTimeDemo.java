package com.wipro.day4;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateTimeDemo {
	public static void main(String[] args) {
        LocalDate d = LocalDate.of(2023, 11, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(d.format(formatter));
    }

}

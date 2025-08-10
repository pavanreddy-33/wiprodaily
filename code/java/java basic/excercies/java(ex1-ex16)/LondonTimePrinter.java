package com.wipro.java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.function.Consumer;

public class LondonTimePrinter {
    public static void main(String[] args) {
        Consumer<String> printTime = zone -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            sdf.setTimeZone(TimeZone.getTimeZone(zone));
            String currentTime = sdf.format(new Date());
            System.out.println("Current time in " + zone + " is: " + currentTime);
        };

        printTime.accept("Asia/Kolkata");
    }
}

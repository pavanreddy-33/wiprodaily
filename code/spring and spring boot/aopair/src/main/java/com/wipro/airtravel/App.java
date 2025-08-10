package com.wipro.airtravel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.airtravel.config.AspectConfig;
import com.wipro.airtravel.exception.NoSeatAvailableException;
import com.wipro.airtravel.service.AirTravelProcess;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectConfig.class);

        AirTravelProcess process = ctx.getBean(AirTravelProcess.class);

        try {
            process.checkIn(true);  
            process.collectBoardingPass();
            process.doSecurityCheck();
            process.doBoarding();
        } catch (NoSeatAvailableException e) {
            System.out.println(e.getMessage());        }

        ctx.close();
    }
}

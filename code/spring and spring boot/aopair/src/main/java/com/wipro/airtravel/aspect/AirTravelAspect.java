package com.wipro.airtravel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.wipro.airtravel.exception.NoSeatAvailableException;

@Aspect
@Component
public class AirTravelAspect {

    @Before("execution(* com.wipro.airtravel.service.AirTravelProcess.checkIn(..))")
    public void showPhotoId(JoinPoint jp) {
        System.out.println("Please show your Photo ID before check-in.");
    }

    @Before("execution(* com.wipro.airtravel.service.AirTravelProcess.doSecurityCheck(..)) || execution(* com.wipro.airtravel.service.AirTravelProcess.doBoarding(..))")
    public void showBoardingPass(JoinPoint jp) {
        System.out.println("Show your boarding pass.");
    }

    @AfterThrowing(pointcut = "execution(* com.wipro.airtravel.service.AirTravelProcess.checkIn(..))", throwing = "ex")
    public void handleNoSeatAvailable(NoSeatAvailableException ex) {
        System.out.println("Please contact your airline manager");
    }
}

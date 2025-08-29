package com.wipro.eurekaserverproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverprojectApplication.class, args);
	}

}

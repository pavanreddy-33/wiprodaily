package com.wipro.flightdatams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FlightDataMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightDataMsApplication.class, args);
	}

}

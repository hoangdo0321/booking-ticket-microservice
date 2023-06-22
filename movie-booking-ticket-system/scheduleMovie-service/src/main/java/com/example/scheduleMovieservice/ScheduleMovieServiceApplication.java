package com.example.scheduleMovieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScheduleMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleMovieServiceApplication.class, args);
	}

}

package com.Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroApp1Application.class, args);
	}

}

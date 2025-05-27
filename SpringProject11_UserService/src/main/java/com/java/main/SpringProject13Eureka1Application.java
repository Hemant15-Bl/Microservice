package com.java.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringProject13Eureka1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProject13Eureka1Application.class, args);
	}

}

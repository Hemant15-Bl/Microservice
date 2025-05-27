package com.java.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringProject11MicroServices1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProject11MicroServices1Application.class, args);
	}

}

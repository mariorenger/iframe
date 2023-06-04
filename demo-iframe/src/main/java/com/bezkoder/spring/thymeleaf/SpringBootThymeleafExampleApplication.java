package com.bezkoder.spring.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootThymeleafExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeleafExampleApplication.class, args);
	}

}

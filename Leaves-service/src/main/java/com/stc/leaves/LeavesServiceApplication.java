package com.stc.leaves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LeavesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeavesServiceApplication.class, args);
	}

}

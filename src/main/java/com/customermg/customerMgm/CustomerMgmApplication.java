package com.customermg.customerMgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "models")

@SpringBootApplication
public class CustomerMgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMgmApplication.class, args);
	}

}

package com.tracker.ProductPriceTrackingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductPriceTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceTrackingSystemApplication.class, args);
	}
}

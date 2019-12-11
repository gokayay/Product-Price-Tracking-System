package com.tracker.ProductPriceTrackingSystem;

import com.tracker.ProductPriceTrackingSystem.controller.ProductController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductPriceTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceTrackingSystemApplication.class, args);
	}
}

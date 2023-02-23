package com.BilBay.bilbay;


import com.BilBay.bilbay.repositories.BidRepository;

import com.BilBay.bilbay.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BilbayApplication {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	BidRepository bidRepository;

	public static void main(String[] args) {
		SpringApplication.run(BilbayApplication.class, args);
	}

}

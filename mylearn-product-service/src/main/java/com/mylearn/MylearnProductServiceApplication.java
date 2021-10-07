package com.mylearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MylearnProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MylearnProductServiceApplication.class, args);
	}

}

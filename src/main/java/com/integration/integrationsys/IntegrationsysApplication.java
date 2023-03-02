package com.integration.integrationsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntegrationsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationsysApplication.class, args);
	}

}

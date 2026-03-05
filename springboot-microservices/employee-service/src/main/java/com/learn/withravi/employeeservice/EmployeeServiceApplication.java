package com.learn.withravi.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
 


@OpenAPIDefinition(
	info = @Info(
		title = "Employee Service API",
		description = "API documentation for Employee Service",
		version = "1.0"	,
		contact = @Contact(
			name = "Ravi Kumar",
			email = "thedevtool@gmail.com",
			url = "dummy-url.com"
		),
		license = @License(
			name = "Apache 2.0",
			url = "dummy-url.com"
		)
		),
		externalDocs = @ExternalDocumentation(
			description = "Employee Service API Documentation",
			url = "dummy-url.com"
	)	
)
@SpringBootApplication
public class EmployeeServiceApplication {
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}

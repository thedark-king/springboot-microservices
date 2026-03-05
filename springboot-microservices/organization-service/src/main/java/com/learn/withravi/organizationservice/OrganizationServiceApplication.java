package com.learn.withravi.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title = "Organization Service API",
		description = "API documentation for Organization Service",
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
			description = "Department Service API Documentation",
			url = "dummy-url.com"
	)	
)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}

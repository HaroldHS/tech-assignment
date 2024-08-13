package com.example.tech_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
 * NOTE: excluding SecurityAutoConfigurations results in disabling default security features from spring-security
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TechAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechAssignmentApplication.class, args);
	}

}

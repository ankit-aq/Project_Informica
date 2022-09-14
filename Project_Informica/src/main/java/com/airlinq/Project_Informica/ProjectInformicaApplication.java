package com.airlinq.Project_Informica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 
 * The ProjectInformicaApplcation class implements the main function
 * to run the spring boot project. It also contains password encoder function
 * to encode the password.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

@SpringBootApplication
public class ProjectInformicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectInformicaApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

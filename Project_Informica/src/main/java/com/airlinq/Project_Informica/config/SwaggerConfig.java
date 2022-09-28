package com.airlinq.Project_Informica.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";



	   private ApiKey apiKeys() {
	        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");



	   }



	   List<SecurityContext> securityContexts() {



	       return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
	    }



	   private List<SecurityReference> sf() {
	        AuthorizationScope scopes = new AuthorizationScope("global", "accessEverything");



	       return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] { scopes }));



	   }
	
	@Bean
	public Docket apiDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContexts())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo getInfo() {
		
		
		return new ApiInfo("Project Informica", "Developed by Team Trainees", "1.0", "Terms of Service",
				new Contact("Team Trainees", "https://ankit.com","teamtrainees@gmail.com"), "License of APIS", "API License URL",
				Collections.emptyList());
	}

}
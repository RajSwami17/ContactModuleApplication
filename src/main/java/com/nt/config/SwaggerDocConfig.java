package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocConfig {
	@Bean
	 public   Docket createDocket() {
		   return  new Docket(DocumentationType.SWAGGER_2)  
				              .select()  
				              .apis(RequestHandlerSelectors.basePackage("com.nt.controller")) 
				              .paths(PathSelectors.regex("/contactus.*")) 
				              .build() 
				              .useDefaultResponseMessages(true)
				              .apiInfo(getApiInfo());
	 }
	
	private  ApiInfo getApiInfo() {
		Contact contact=new Contact("Rajesh Swami","http://www.contactmodule.com/contactus","swamirajesh@gmail.com");
		return  new ApiInfo("CustomerContact API",
				                            "Gives Info About Customer Contacts", 
				                            "3.4.RELEASE",
				                            "http://www.contactmodule.com/license",
				                            contact,
				                            "GNU Public",
				                            "http://apache.org/license/gnu", 
				                            Collections.emptyList());
	}

}

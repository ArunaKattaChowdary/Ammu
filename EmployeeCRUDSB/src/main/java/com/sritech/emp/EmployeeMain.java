package com.sritech.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sritech.emp")
public class EmployeeMain extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		
		System.out.println("Main app started ");
		
		SpringApplication.run(EmployeeMain.class, args);
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(EmployeeMain.class);
	}


}

package com.northstrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NorthstratRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthstratRestApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(NorthstratRestApplication.class);
	  }
}

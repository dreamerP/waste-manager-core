package com.example.wastemanagercore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WasteManagerCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteManagerCoreApplication.class, args);
	}
	  @Bean
	   public RestTemplate restTemplate(){
	      return new RestTemplate();
	   }
}

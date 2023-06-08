package com.akbankbootcamp.OpenWeatherMapApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients
//@EnableSwagger2
public class OpenWeatherMapAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherMapAppApplication.class, args);
	}

}

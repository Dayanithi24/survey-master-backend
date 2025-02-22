package com.example.surveymaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SurveymasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveymasterApplication.class, args);
	}

}

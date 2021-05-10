package com.example.myphotoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyphotoappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyphotoappApplication.class, args);
	}

}
 
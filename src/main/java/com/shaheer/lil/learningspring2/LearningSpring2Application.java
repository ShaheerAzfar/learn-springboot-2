package com.shaheer.lil.learningspring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.shaheer.udemy.springbootrestapi"})
public class LearningSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpring2Application.class, args);
	}

}

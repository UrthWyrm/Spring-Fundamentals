package com.codingdojo.gettingfamiliar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GettingFamiliarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GettingFamiliarApplication.class, args);
	}
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String python() {
		return "Python/Django is awesome!";
	}
	@RequestMapping("/java")
	public String java() {
		return "Java/Spring is better!";
	}

}

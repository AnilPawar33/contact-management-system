package com.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ContactFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactFormApplication.class, args);
		
	}

}

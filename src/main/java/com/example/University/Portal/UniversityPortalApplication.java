package com.example.University.Portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UniversityPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityPortalApplication.class, args);
	}

}

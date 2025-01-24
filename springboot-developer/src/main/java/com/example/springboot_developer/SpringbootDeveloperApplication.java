package com.example.springboot_developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = "com.example.springboot_developer")
public class SpringbootDeveloperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDeveloperApplication.class, args);
	}

}

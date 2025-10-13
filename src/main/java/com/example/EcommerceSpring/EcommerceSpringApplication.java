package com.example.EcommerceSpring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceSpringApplication {

	public static void main(String[] args) {

        // Scanner dotenv = new Scanner();
        Dotenv dotenv = Dotenv.configure().load();
        dotenv.entries().forEach(
                entry -> System.setProperty(entry.getKey() , entry.getValue())
        );
        SpringApplication.run(EcommerceSpringApplication.class, args); // think as it starts the routing layer
	}
}
package com.proyecto.colmenial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ColmenialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColmenialApplication.class, args);
	}
}

package org.santiarerhi.mirl.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class MirlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MirlApiApplication.class, args);
	}
}

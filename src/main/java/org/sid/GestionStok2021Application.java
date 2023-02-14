package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"org.sid"})
@EnableJpaAuditing
//@EnableAutoConfiguration
public class GestionStok2021Application {

	public static void main(String[] args) {
		SpringApplication.run(GestionStok2021Application.class, args);
	}

}

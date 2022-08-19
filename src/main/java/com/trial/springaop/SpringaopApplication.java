package com.trial.springaop;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
public class SpringaopApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringaopApplication.class);
		springApplication.setBannerMode(Banner.Mode.OFF);
		springApplication.run(args);
	}

}

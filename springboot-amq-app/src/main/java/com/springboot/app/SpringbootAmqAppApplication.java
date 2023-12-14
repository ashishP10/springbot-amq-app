package com.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootAmqAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAmqAppApplication.class, args);
	}

}

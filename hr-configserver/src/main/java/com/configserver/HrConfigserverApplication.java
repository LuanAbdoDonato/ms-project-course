package com.configserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigserverApplication{

	@Value("${spring.cloud.config.server.git.username}")
	private String user;

	@Value("${spring.cloud.config.server.git.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(HrConfigserverApplication.class, args);
	}

}

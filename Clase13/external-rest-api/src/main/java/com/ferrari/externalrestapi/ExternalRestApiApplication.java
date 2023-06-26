package com.ferrari.externalrestapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExternalRestApiApplication implements CommandLineRunner {

	@Value("${server.port}")
	private String port;
	public static void main(String[] args) {
		SpringApplication.run(ExternalRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App running on http://localhost:" + port + "/api/v1");
		System.out.println("Check H2 console on http://localhost:" + port + "/h2");
	}

}

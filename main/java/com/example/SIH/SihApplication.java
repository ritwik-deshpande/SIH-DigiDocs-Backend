package com.example.SIH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@SpringBootApplication
public class SihApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(SihApplication.class, args);

		FileHandler handler = new FileHandler("activity_log.log", true);

		Logger logger = Logger.getLogger("com.example.SIH");
		logger.addHandler(handler);

	}

}

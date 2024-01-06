package com.example.cms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EldanLord {

	private static Logger LOG = LoggerFactory
			.getLogger(EldanLord.class);

	public static void main(String[] args) {
		SpringApplication.run(EldanLord.class, args);
		LOG.info("APPLICATION IS RUNNING");
	}
}

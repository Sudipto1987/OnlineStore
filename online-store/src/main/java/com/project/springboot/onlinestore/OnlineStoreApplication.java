package com.project.springboot.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class OnlineStoreApplication {

	public static void main(String[] args) {
		/*
		 * System.out.println("Sersion check ");
		 * System.out.println(org.hibernate.Version.getVersionString());
		 * System.out.println("version: " + SpringVersion.getVersion());
		 */
		SpringApplication.run(OnlineStoreApplication.class, args);
	}

}

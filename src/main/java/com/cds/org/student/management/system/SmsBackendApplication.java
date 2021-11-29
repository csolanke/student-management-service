package com.cds.org.student.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cds.org.student.management.controller", "com.cds.org.student.management.system.exception",
		"com.cds.org.student.management.system.model" })
public class SmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsBackendApplication.class, args);
	}

}

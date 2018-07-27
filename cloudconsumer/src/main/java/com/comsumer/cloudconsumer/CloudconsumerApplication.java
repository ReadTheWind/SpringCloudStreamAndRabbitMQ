package com.comsumer.cloudconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.comsumer.cloudconsumer")
public class CloudconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudconsumerApplication.class, args);
	}
}

package com.provider.cloudstreamprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuhuan
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.provider.cloudstreamprovider")
public class CloudstreamproviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudstreamproviderApplication.class, args);
	}
}

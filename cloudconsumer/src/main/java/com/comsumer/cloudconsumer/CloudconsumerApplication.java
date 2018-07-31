package com.comsumer.cloudconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author liuhuan
 * main
 */
@Configuration
@SpringBootApplication
@ComponentScan({"com.comsumer.cloudconsumer","com.common"})
@EnableJpaRepositories(basePackages = "com.common.api")
@EntityScan(basePackages = "com.common.api.domain")
public class CloudconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudconsumerApplication.class, args);
	}
}

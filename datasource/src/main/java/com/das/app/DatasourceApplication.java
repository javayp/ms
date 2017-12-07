package com.das.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.das")
@EntityScan("com.das.model")
@EnableJpaRepositories("com.das.repo")
public class DatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasourceApplication.class, args);
	}
}

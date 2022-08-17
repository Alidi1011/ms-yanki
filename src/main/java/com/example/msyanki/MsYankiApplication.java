package com.example.msyanki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class MsYankiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsYankiApplication.class, args);
	}
}

package com.example.msyanki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class MsYankiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsYankiApplication.class, args);
	}

	@KafkaListener(topics = "${kafka.topic.name}")
	public void listener(String message) {
		log.debug("Message received {} ", message);
		//Do something
		log.info("Mensaje recibido por el consumidor: " + message);
	}

}

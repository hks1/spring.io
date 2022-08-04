package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.consumingrest.Quote;
import com.example.restservice.Greeting;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.example.demo", "com.example.restservice", "com.example.consumingrest"})
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// https://spring.io/quickstart
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	// https://spring.io/guides/gs/consuming-rest/
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	/*
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
	*/
	
	// above rest end point not working,
	// switching to local endpoint which should be running as part of 'restservice' exercise
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
			log.info("In the CommandLineRunner, waiting for response...");
			log.info(greeting.toString());
		};
	}
	
}

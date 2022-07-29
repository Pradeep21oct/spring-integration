package com.spring.integartion;

import com.spring.integartion.model.Event;
import com.spring.integartion.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIntegrationDemoApplication implements CommandLineRunner {

	@Autowired
	private EventService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		for (int i=0;i<100;i++) {
			service.publishTo(new Event(i, "Event " + i));
		}
	}
}

package com.spring.integartion;

import com.spring.integartion.model.Event;
import com.spring.integartion.service.EventService;
import com.spring.integartion.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationDemoApplication implements CommandLineRunner {

	@Autowired
	private EventService service;

	@Autowired
	private RouterService routerService;
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		for (int i=0;i<10;i++) {
			routerService.publishTo(new Event(i, "Event " + i));
		}
	}
}

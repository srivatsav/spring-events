package com.test.event;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.test.*")
@Configuration
@EnableConfigurationProperties
public class SpringEventsApplication {
	
	private static TransactionEventPublisher publisher;

	@Autowired
	TransactionEventPublisher eventPublisher;
	
	@PostConstruct
	public void init() {
		SpringEventsApplication.publisher = eventPublisher;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEventsApplication.class, args);
		Transaction failedTransaction = new Transaction();
		failedTransaction.setTransactionStatus("failed");
		publisher.doPublishEvent(failedTransaction);
	}
}

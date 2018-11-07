package com.test.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventPublisher implements ApplicationEventPublisherAware{
	
	ApplicationEventPublisher eventPublisher;
	
	public void doPublishEvent(final Transaction failedTransaction) {
		TransactionEvent txnEvent = new TransactionEvent(this, failedTransaction,"cancel event");
		eventPublisher.publishEvent(txnEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
		
	}	
}

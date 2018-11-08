package com.test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventPublisher implements ApplicationEventPublisherAware{
	
	ApplicationEventPublisher eventPublisher;
	
	/**
	 * applicationEventMulticaster -> for handling events asynchronously.
	 */
	@Autowired
	ApplicationEventMulticaster applicationEventMulticaster;
	
	public void doPublishEvent(final Transaction failedTransaction) {
		TransactionEvent txnEvent = new TransactionEvent(this, failedTransaction,"cancel event");
		applicationEventMulticaster.multicastEvent(txnEvent);
		//eventPublisher.publishEvent(txnEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
		
	}	
}

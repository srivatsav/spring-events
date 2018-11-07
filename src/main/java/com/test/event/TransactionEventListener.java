package com.test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventListener implements ApplicationListener<TransactionEvent>{

	@Override
	public void onApplicationEvent(TransactionEvent event) {
		System.out.println("In listener :: "+event.getEventType());
	}
}

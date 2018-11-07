package com.test.event;

import org.springframework.context.ApplicationEvent;

public class TransactionEvent extends ApplicationEvent {

	private static final long serialVersionUID = -8014677686567571396L;

	private Transaction transaction;

	private String eventType;

	public TransactionEvent(Object source,Transaction transaction,String eventType) {
		super(source);
		this.transaction = transaction;
		this.eventType = eventType;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}

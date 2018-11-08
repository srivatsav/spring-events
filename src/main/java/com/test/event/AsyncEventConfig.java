package com.test.event;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.support.TaskUtils;


@Configuration
public class AsyncEventConfig {
	
	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMultiCaster = new SimpleApplicationEventMulticaster();
		eventMultiCaster.setTaskExecutor(getAsyncExecutor());
		eventMultiCaster.setErrorHandler(TaskUtils.LOG_AND_SUPPRESS_ERROR_HANDLER);
		return eventMultiCaster;

	}
	
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1000);
		executor.setMaxPoolSize(3000);
		executor.setQueueCapacity(1000);
		executor.setThreadNamePrefix("CAN -");
		executor.initialize();
		return executor;
	}
}

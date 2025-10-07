package com.postservice.domain.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import com.postservice.domain.model.PostProcessorListener;
import com.postservice.infrastruct.rabbitmq.RabbitMQConfig;

@Configuration
public class ListenerRabbitService {

	@RabbitListener(queues = RabbitMQConfig.QUEUE_TEXT_PROCESSOR_POST)
	public void listenerPostProcessor(PostProcessorListener post) {
		
	}
}

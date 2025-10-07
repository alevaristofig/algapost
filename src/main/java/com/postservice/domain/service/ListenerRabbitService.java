package com.postservice.domain.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.postservice.domain.model.PostProcessorListener;
import com.postservice.infrastruct.rabbitmq.RabbitMQConfig;

@Configuration
public class ListenerRabbitService {
	
	@Autowired
	private PostService service;

	@RabbitListener(queues = RabbitMQConfig.QUEUE_TEXT_PROCESSOR_POST)
	public void listenerPostProcessor(PostProcessorListener post) {
		service.gravar(post);
	}
}

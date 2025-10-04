package com.postservice.domain.service;

import java.util.UUID;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.postservice.api.model.PostInput;
import com.postservice.infrastruct.rabbitmq.RabbitMQConfig;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificacaoRabbitService {

	private RabbitTemplate rabbitTemplate;
	
	public void notiticar(PostInput input, String exchange, UUID id) {
		
		MessagePostProcessor messagePostProcessor = message -> {
			message.getMessageProperties().setHeader("postId", id);
			
			return message;
		};
		
		rabbitTemplate.convertAndSend("", RabbitMQConfig.QUEUE_TEXT_PROCESSOR, input, messagePostProcessor);
	}
}

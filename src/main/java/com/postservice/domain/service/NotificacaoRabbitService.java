package com.postservice.domain.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.postservice.api.model.PostInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class NotificacaoRabbitService {

	private RabbitTemplate rabbitTemplate;
	
	public void notiticar(PostInput input, String exchange) {
		rabbitTemplate.convertAndSend(exchange, "", input);
	}
}

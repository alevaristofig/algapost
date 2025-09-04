package com.postservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postservice.api.model.PostInput;
import com.postservice.infrastruct.rabbitmq.RabbitMQConfig;

@Service
public class PostService {
	
	@Autowired
	private NotificacaoRabbitService notificacaoRabbitService;	

	public void criar(PostInput input) {
		notificarRabbitMQ(input);
	}
	
	private void notificarRabbitMQ(PostInput input) {
		try {
			notificacaoRabbitService.notiticar(input, RabbitMQConfig.QUEUE_TEXT_PROCESSOR);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}

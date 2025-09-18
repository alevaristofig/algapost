package com.postservice.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postservice.api.model.PostInput;
import com.postservice.infrastruct.rabbitmq.RabbitMQConfig;

@Service
public class PostService {
	
	@Autowired
	private NotificacaoRabbitService notificacaoRabbitService;	

	public void criar(PostInput input, UUID id) {
		notificarRabbitMQ(input,id);
	}
	
	private void notificarRabbitMQ(PostInput input, UUID id) {
		try {
			notificacaoRabbitService.notiticar(input, RabbitMQConfig.FANOUT_TEXT_PROCESSOR, id);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}

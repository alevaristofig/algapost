package com.postservice.domain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postservice.api.model.PostInput;
import com.postservice.api.model.PostSummaryOutput;
import com.postservice.domain.model.Post;
import com.postservice.domain.model.PostProcessorListener;
import com.postservice.domain.repository.PostProcessorRepository;
import com.postservice.domain.repository.PostRepository;
import com.postservice.infrastruct.rabbitmq.RabbitMQConfig;

@Service
public class PostService {
	
	@Autowired
	private NotificacaoRabbitService notificacaoRabbitService;	
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private PostProcessorRepository repositoryProcessor;

	public void criar(PostInput input, UUID id) {
		notificarRabbitMQ(input,id);
	}
	
	public void gravarPost(PostSummaryOutput postInput) {
		
		Post post = new Post();
		post.setId(postInput.getId());
		post.setAuthor(postInput.getAuthor());
		post.setTitle(postInput.getTitle());
		post.setBody(postInput.getSummary());
		
		
		repository.save(post);
	}
	
	public void gravar(PostProcessorListener post) {
		repositoryProcessor.save(post);
	}
	
	private void notificarRabbitMQ(PostInput input, UUID id) {
		try {
			notificacaoRabbitService.notiticar(input, RabbitMQConfig.FANOUT_TEXT_PROCESSOR, id);
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}	
}

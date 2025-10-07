package com.postservice.api.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postservice.api.model.PostInput;
import com.postservice.api.model.PostSummaryOutput;
import com.postservice.domain.model.Post;
import com.postservice.domain.service.PostService;
import com.postservice.domain.utility.IdGenerator;

@RestController
@RequestMapping(path = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public List<Post> listar() {
		return service.listar();
	}
	
	@PostMapping
	public PostSummaryOutput criar(@RequestBody @Validated PostInput input) {
		UUID id = IdGenerator.generateTimeBaseUUID();
		
		service.gravarPost(PostSummaryOutput.builder()
				.id(id.toString())
				.title(input.getTitle())
				.summary(input.getBody())
				.author(input.getAuthor())
				.build());
		
		service.criar(input,id);
		
		return PostSummaryOutput.builder()
				.id(id.toString())
				.title(input.getTitle())
				.summary(input.getBody())
				.author(input.getAuthor())
				.build();
	}

}

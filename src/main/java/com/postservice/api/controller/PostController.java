package com.postservice.api.controller;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postservice.api.model.PostInput;
import com.postservice.api.model.PostSummaryOutput;
import com.postservice.domain.service.PostService;
import com.postservice.domain.utility.IdGenerator;

@RestController
@RequestMapping(path = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping
	public PostSummaryOutput criar(PostInput input) {
		UUID id = IdGenerator.generateTimeBaseUUID();
		
		service.criar(input,id);
		
		return PostSummaryOutput.builder()
				.id(id.toString())
				.title(input.getTitle())
				.summary(input.getBody())
				.author(input.getAuthor())
				.build();
	}

}

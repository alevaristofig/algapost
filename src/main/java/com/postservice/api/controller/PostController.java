package com.postservice.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postservice.api.model.PostInput;
import com.postservice.api.model.PostSummaryOutput;
import com.postservice.domain.service.PostService;

@RestController
@RequestMapping(path = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping
	public PostSummaryOutput criar(PostInput input) {
		service.criar(input);
		
		return PostSummaryOutput.builder()
				.title(input.getTitle())
				.summary(input.getBody())
				.author(input.getAuthor())
				.build();
	}

}

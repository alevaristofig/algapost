package com.postservice.api.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postservice.api.model.PostInput;
import com.postservice.api.model.PostOutput;

@RestController
@RequestMapping(path = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
	
	@PostMapping
	public PostOutput criar(PostInput input) {
		
	}

}

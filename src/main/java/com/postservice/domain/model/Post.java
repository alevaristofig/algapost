package com.postservice.domain.model;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("post")
public class Post {
	
	private UUID id;

	private String title;
	
	private String body;
	
	private String author;
}

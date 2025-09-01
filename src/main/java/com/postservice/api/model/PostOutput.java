package com.postservice.api.model;

import lombok.Data;

@Data
public class PostOutput {

	private String id;
	private String title;
	private String body;
	private String author;
	private Integer wordCount;
	private Float calculatedValue;
}

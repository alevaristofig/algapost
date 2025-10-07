package com.postservice.domain.model;

import lombok.Data;

@Data
public class PostProcessorListener {

	private String postId;
	private Integer wordCount;
	private Float calculatedValue;
}

package com.postservice.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.postservice.domain.model.PostProcessorListener;

public interface PostProcessorRepository extends MongoRepository<PostProcessorListener, String> {

}

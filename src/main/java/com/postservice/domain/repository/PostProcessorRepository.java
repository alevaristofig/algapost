package com.postservice.domain.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.postservice.domain.model.PostProcessorListener;

public interface PostProcessorRepository extends MongoRepository<PostProcessorListener, String> {

	@Query("{'postId': ?0}")
	Optional<PostProcessorListener> findByPostId(String id);
}

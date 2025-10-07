package com.postservice.domain.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.postservice.domain.model.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}

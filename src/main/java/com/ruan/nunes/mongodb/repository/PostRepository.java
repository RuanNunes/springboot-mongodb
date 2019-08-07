package com.ruan.nunes.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ruan.nunes.mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}

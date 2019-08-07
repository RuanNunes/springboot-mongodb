package com.ruan.nunes.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruan.nunes.mongodb.domain.Post;
import com.ruan.nunes.mongodb.repository.PostRepository;
import com.ruan.nunes.mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired 
	private PostRepository repository;
	
	public List<Post> findAll(){
		return repository.findAll();
	}
	
	public Post finById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}

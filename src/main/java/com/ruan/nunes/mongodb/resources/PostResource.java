package com.ruan.nunes.mongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruan.nunes.mongodb.domain.Post;
import com.ruan.nunes.mongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = postService.finById(id);
		return ResponseEntity.ok().body(post);
	}	
}

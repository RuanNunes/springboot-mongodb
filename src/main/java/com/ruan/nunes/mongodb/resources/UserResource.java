package com.ruan.nunes.mongodb.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ruan.nunes.mongodb.domain.User;
import com.ruan.nunes.mongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable String id){
		User user = userService.finById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody User obj){
		User user = userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<User> delete(@PathVariable String id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody User obj, @PathVariable String id){
		obj.setId(id);
		obj = userService.update(obj);
		return ResponseEntity.noContent().build();
	}
}

package com.ruan.nunes.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruan.nunes.mongodb.domain.User;
import com.ruan.nunes.mongodb.repository.UserRepository;
import com.ruan.nunes.mongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User finById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}

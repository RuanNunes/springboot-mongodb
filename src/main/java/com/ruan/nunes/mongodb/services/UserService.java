package com.ruan.nunes.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruan.nunes.mongodb.domain.User;
import com.ruan.nunes.mongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}

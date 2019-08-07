package com.ruan.nunes.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruan.nunes.mongodb.domain.Post;
import com.ruan.nunes.mongodb.domain.User;
import com.ruan.nunes.mongodb.repository.PostRepository;
import com.ruan.nunes.mongodb.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("BR"));
		Post post1 = new Post(null, sdf.parse("21/03/2019"), "Partiu viage", "Vou viajar para londres abraços", maria);
		Post post2 = new Post(null, sdf.parse("22/03/2019"), "Cheguei da viage", "cheguei muito bem em londres amigos", maria);
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}

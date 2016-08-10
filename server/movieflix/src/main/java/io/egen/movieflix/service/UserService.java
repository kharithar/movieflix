package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.model.User;
import io.egen.movieflix.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	@Transactional
	public User create(User user) {
		return userRepository.create(user);
	}
	public User login(String username, String password) {
		return userRepository.login(username,password);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(String userId) {
		return userRepository.findById(userId);
	}
}

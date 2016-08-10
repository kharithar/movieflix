package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.model.User;

public interface IUserRepository {
	
	public User create(User user);
	public User login(String username, String password);
	public List<User> findAll();
	public User findById(String userId);
}

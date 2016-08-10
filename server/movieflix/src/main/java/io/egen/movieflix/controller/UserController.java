package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.model.User;
import io.egen.movieflix.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST,path="/create",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	@RequestMapping(method = RequestMethod.POST,path="/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User login(@RequestBody User user) {
		return userService.login( user.getUserName(),  user.getPassword());
	}
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		return userService.findAll();
	}
	@RequestMapping(method = RequestMethod.GET,path="/find/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User find(@PathVariable("userId")String userId) {
		return userService.findById(userId);
	}
}

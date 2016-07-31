package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.model.Comment;
import io.egen.movieflix.model.UserRating;
import io.egen.movieflix.service.CommentService;

@RestController
@RequestMapping(path = "comments")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(method = RequestMethod.POST,path="/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment add(@RequestBody Comment comment) {
		return commentService.add(comment);		 
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="/update/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment update(@PathVariable("movieId") String movieId,@RequestBody Comment comment) {
		 return commentService.update(movieId,comment);		 
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/find/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> find(@PathVariable("movieId")String movieId) {
		return commentService.find(movieId);
	}

}

package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.model.UserRating;
import io.egen.movieflix.service.UserRatingService;

@RestController
@RequestMapping(path = "userratings")
public class UserRatingController {
	
	@Autowired
	UserRatingService userRatingService;
	
	@RequestMapping(method = RequestMethod.GET,path="/find/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<UserRating> find(@PathVariable("movieId")String movieId) {
		return userRatingService.findAllRatings(movieId);
	}
	
	@RequestMapping(method = RequestMethod.POST,path="/add/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRating add(@PathVariable("movieId") String movieId,@RequestBody UserRating userRating) {
		 return userRatingService.add(movieId,userRating);		 
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="/update/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserRating update(@PathVariable("movieId") String movieId,@RequestBody UserRating userRating) {
		 return userRatingService.update(movieId,userRating);		 
	}
}

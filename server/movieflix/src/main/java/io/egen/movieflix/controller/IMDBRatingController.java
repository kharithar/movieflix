package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.model.IMDBRating;
import io.egen.movieflix.model.Movie;
import io.egen.movieflix.service.IMDBRatingService;

@RestController
@RequestMapping(path = "imdbrating")
public class IMDBRatingController {
	
	@Autowired
	IMDBRatingService imdbRatingService;
	
	@RequestMapping(method = RequestMethod.PUT,path="{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public IMDBRating update(@PathVariable("movieId") String movieId,@RequestBody IMDBRating imdbRating) {
		 return imdbRatingService.update(movieId,imdbRating);		 
	}
	

}

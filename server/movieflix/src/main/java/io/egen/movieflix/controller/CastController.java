package io.egen.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.model.Cast;
import io.egen.movieflix.service.CastService;

@RestController
@RequestMapping(path = "cast")
public class CastController {
	
	@Autowired
	CastService castService;
	
	@RequestMapping(method = RequestMethod.PUT,path="{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cast update(@PathVariable("movieId") String movieId,@RequestBody Cast cast) {
		 return castService.update(movieId,cast);		 
	}
	
	
}

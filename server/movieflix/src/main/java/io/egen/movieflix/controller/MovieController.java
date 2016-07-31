package io.egen.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.model.Movie;
import io.egen.movieflix.service.MovieService;
@RestController
@RequestMapping(path = "movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(method = RequestMethod.POST,path="/create",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {		 
		return movieService.create(movie);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/findByType/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByType(@PathVariable("type")String type) {
		return movieService.findByType(type);
	}
	@RequestMapping(method = RequestMethod.GET,path="/findByYear/{year}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByYear(@PathVariable("type")int year) {
		return movieService.findByYear(year);
	}
	@RequestMapping(method = RequestMethod.GET,path="/findByGenre/{genre}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByGenre(@PathVariable("type")String genre) {
		return movieService.findByGenre(genre);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path="{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("movieId") String movieId,@RequestBody Movie movie) {
		return movieService.update(movie);
	}
		
	@RequestMapping(method = RequestMethod.GET,path="/sortByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear() {
		return movieService.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByIMDBVotes",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByIMDBVotes() {
		return movieService.sortByIMDBVotes();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="/sortByIMDBRatings",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByIMDBRatings() {
		return movieService.sortByIMDBRatings();
	}
	
	@RequestMapping(method = RequestMethod.DELETE,path="/delete/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("movieId") String movieId) {
		 movieService.delete(movieId);
	}
	

}

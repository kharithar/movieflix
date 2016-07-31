package io.egen.movieflix.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import io.egen.movieflix.model.Movie;

public interface IMovieService {
	
	public Movie create(Movie movie);
	public List<Movie> findByType(String type);
	public List<Movie> findByYear(int year);
	public List<Movie> findByGenre(String genre);
	public Movie update(Movie movie);
	public List<Movie> sortByIMDBRatings();
	public List<Movie> sortByIMDBVotes();
	public List<Movie> sortByYear();
	public void delete(String movieId);
}

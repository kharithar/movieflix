package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.model.Movie;

public interface IMovieRepository {
	
	public Movie create(Movie movie);
	
	public List<Movie> findByType(String type);
	public List<Movie> findByYear(int year);
	public List<Movie> findByGenre(String genre);
	
	public Movie findMovieById(String movieId);
	
	// update movie details
	public Movie update(Movie movie);
	//delete movie
	public List<Movie> sortByIMDBRatings();
	public List<Movie> sortByIMDBVotes();
	public List<Movie> sortByYear();
	public void delete(Movie movie);
}

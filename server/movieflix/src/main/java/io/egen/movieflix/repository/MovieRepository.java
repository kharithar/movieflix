package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.model.Movie;

@Repository
public class MovieRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}
	
	public List<Movie> findByType(String type) {
		return (List<Movie>) em.find(Movie.class, type);
	}
	
	public List<Movie> findByYear(int year) {
		return (List<Movie>) em.find(Movie.class, year);
	}
	public List<Movie> findByGenre(String genre) {
		return (List<Movie>) em.find(Movie.class, genre);
	}
	
	public Movie update(Movie movie) {
		return em.merge(movie);
		
	}
	
	public Movie findMovieById(String movieId) {
		return em.find(Movie.class, movieId);
	}
	
	public List<Movie> sortByIMDBRatings() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByIMDBRatings", Movie.class);
		
		List<Movie> movieList =  query.getResultList();
		if(movieList != null && movieList.size() == 1) {
			return movieList;
		}
		return null;
	}
	public List<Movie> sortByIMDBVotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByIMDBVotes", Movie.class);
		
		List<Movie> movieList =  query.getResultList();
		if(movieList != null && movieList.size() == 1) {
			return movieList;
		}
		return null;
		
	}
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear", Movie.class);
		
		List<Movie> movieList =  query.getResultList();
		if(movieList != null && movieList.size() == 1) {
			return movieList;
		}
		return null;
	}
	public void delete(Movie movie){
		em.remove(movie);
	}
}

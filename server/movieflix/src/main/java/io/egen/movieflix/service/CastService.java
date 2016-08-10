package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.model.Cast;
import io.egen.movieflix.model.Movie;
import io.egen.movieflix.repository.CastRepository;
import io.egen.movieflix.repository.MovieRepository;

@Service
public class CastService {
	@Autowired
	CastRepository castRepository;
	@Autowired
	MovieRepository movieRepository;
	@Transactional
	public Cast create(Cast cast){
		return castRepository.create(cast);
	}
	@Transactional
	public Cast update(String movieId, Cast cast) {
		Movie movie = movieRepository.findMovieById(movieId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		return castRepository.update(cast);
	}
	@Transactional
	public void delete(Cast cast) {
		//cast = castRepository.findCastByID(cast.getCastId());
		System.out.println("before calling repository");
		castRepository.delete(cast);
		System.out.println("after calling repository");
	}
	
	public Cast find(String movieId) {
		return  castRepository.find(movieId);
	}
	public Cast findCastByID(String castId) {
		return  castRepository.findCastByID(castId);
	}

}

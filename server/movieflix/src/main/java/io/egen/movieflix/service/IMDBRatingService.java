package io.egen.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.model.IMDBRating;
import io.egen.movieflix.model.Movie;
import io.egen.movieflix.repository.IMDBRatingRepository;
import io.egen.movieflix.repository.MovieRepository;
@Service
public class IMDBRatingService {
	@Autowired
	IMDBRatingRepository imdbRatingRepository;
	@Autowired
	MovieRepository movieRepository;
	//add rating
	public IMDBRating add(IMDBRating imdbRating) {
		return imdbRatingRepository.add(imdbRating);
	}
	
	//view rating
	public IMDBRating find(String movieId){
		return imdbRatingRepository.find(movieId);
	}
	
	//update rating
	public IMDBRating update(String movieId,IMDBRating imdbRating) {
		
		Movie movie = movieRepository.findMovieById(movieId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		return imdbRatingRepository.update(imdbRating);
	}
	
	//delete rating
	public void delete(IMDBRating imdbRating) {
		//IMDBRating imdbRating = imdbRatingRepository.findRatingByID(imdbRatingId);
		 imdbRatingRepository.delete(imdbRating);
	}
}

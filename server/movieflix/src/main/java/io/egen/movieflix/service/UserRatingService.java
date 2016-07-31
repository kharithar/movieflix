package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.model.Movie;
import io.egen.movieflix.model.User;
import io.egen.movieflix.model.UserRating;
import io.egen.movieflix.repository.MovieRepository;
import io.egen.movieflix.repository.UserRatingRepository;
import io.egen.movieflix.repository.UserRepository;
@Service
public class UserRatingService {
	@Autowired
	UserRatingRepository userRatingRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;

	//add rating
	@Transactional
	public UserRating add(String movieId,UserRating userRating) {
		//String movieId = userRating.getMovie().getMovieId();
		String userId = userRating.getUser().getUserId();
		Movie movie = movieRepository.findMovieById(movieId);
		User user = userRepository.findById(userId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		userRating.setMovie(movie);
		userRating.setUser(user);
		return userRatingRepository.add(userRating);
	}
	
	//view rating
	public List<UserRating> findAllRatings(String movieId) {
		return userRatingRepository.findAllRatings(movieId);
	}
	
	//update rating
	@Transactional
	public UserRating update(String movieId,UserRating userRating) {
		String userId = userRating.getUser().getUserId();
		Movie movie = movieRepository.findMovieById(movieId);
		User user = userRepository.findById(userId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		userRating.setMovie(movie);
		userRating.setUser(user);
		return userRatingRepository.update(userRating);
	}
	
	//delete rating
	@Transactional
	public void delete(String userRatingId){
		UserRating userRating = userRatingRepository.findRating(userRatingId);
		 userRatingRepository.delete(userRating);
	}
	
	@Transactional
	public void deleteAllUserRatings(List<UserRating> userRatings) {
		userRatingRepository.deleteAllUserRatings(userRatings);
	}
}

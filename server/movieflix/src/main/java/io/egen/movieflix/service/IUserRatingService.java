package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.model.UserRating;

public interface IUserRatingService {
	
	//add rating
	public List<UserRating> add(List<UserRating> userRatingList);
	
	//view rating
	public List<UserRating> findAllRatings(String movieId);
	
	//update rating
	public UserRating update(String movieId,UserRating userRating);
	
	//delete rating
	public void delete(String userRatingId);
	
	public void deleteAllUserRatings(List<UserRating> userRatings) ;
}

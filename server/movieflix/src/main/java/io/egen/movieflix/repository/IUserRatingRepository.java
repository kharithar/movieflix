package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.model.UserRating;

public interface IUserRatingRepository {
	
	//add rating
	public List<UserRating> add(List<UserRating> userRatingList);
	
	//view rating
	public List<UserRating> findAllRatings(String movieId);
	
	//update rating
	public UserRating update(UserRating userRating);
	
	//delete rating
	public void delete(String userRatingId);
	
	public void deleteAllUserRatings(List<UserRating> userRatings);
	
	public UserRating findRating(String userRatingId);
}

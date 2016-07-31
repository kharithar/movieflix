package io.egen.movieflix.service;

import io.egen.movieflix.model.IMDBRating;

public interface IIMDBRatingService {
	
	//add rating
	public IMDBRating add(IMDBRating imdbRating);
	
	//view rating
	public IMDBRating find(String movieId);
	
	//update rating
	public IMDBRating update(String movieId,IMDBRating imdbRating);
	
	//delete rating
	public void delete(IMDBRating imdbRating);
}

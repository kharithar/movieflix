package io.egen.movieflix.repository;

import io.egen.movieflix.model.IMDBRating;

public interface IIMDBRatingRepository {
	
		//add rating
		public IMDBRating add(IMDBRating imdbRating);
		
		//view rating
		public IMDBRating find(String movieId);
		
		//update rating
		public IMDBRating update(IMDBRating imdbRating);
		
		//delete rating
		public void delete(IMDBRating imdbRating);
}

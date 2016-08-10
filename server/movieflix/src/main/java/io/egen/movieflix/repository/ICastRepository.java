package io.egen.movieflix.repository;

import io.egen.movieflix.model.Cast;

public interface ICastRepository {
	
	public Cast create(Cast cast);
	
	public Cast update(Cast cast);
	public void delete(Cast cast);
	
	public Cast find(String movieId);
	
	public Cast findCastByID(String castId);
}

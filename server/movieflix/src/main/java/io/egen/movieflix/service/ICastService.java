package io.egen.movieflix.service;

import io.egen.movieflix.model.Cast;

public interface ICastService {
	
	public Cast create(Cast cast);
	
	public Cast update(String movieId,Cast cast);
	
	public void delete(Cast cast);
	
	public Cast find(String movieId);
	public Cast findCastByID(String castId);
}

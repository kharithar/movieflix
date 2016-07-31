package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.model.Cast;
import io.egen.movieflix.model.IMDBRating;
@Repository
public class IMDBRatingRepository {
	@PersistenceContext
	private EntityManager em;
	//add rating
	public IMDBRating add(IMDBRating imdbRating) {
		em.persist(imdbRating);
		return imdbRating;
	}
	
	//update rating
	public IMDBRating update(IMDBRating imdbRating) {
		em.merge(imdbRating);
		return imdbRating;
	}
	
	public void delete(IMDBRating imdbRating) {
		em.remove(imdbRating);
	}
	
	public IMDBRating find(String movieId) {
		TypedQuery<IMDBRating> query = em.createNamedQuery("IMDBRating.viewIMDBRating", IMDBRating.class);
		query.setParameter("pmovieId",movieId);	
		List<IMDBRating> imdbList =  query.getResultList();
		if(imdbList != null && imdbList.size() == 1) {
			return imdbList.get(0);
		}
		return null;
	}
	
	public IMDBRating findRatingByID(String imdbRatingId) {
		TypedQuery<IMDBRating> query = em.createNamedQuery("IMDBRating.viewIMDBRatingByID", IMDBRating.class);
		query.setParameter("pimdbRatingId",imdbRatingId);	
		List<IMDBRating> imdbList =  query.getResultList();
		if(imdbList != null && imdbList.size() == 1) {
			return imdbList.get(0);
		}
		return null;
	}
}

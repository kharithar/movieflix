package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.model.Cast;
@Repository
public class CastRepository {
	@PersistenceContext
	private EntityManager em;
	
	public Cast create(Cast cast) {
		em.persist(cast);
		return cast;
	}
	
	public Cast update(Cast cast) {
		em.merge(cast);
		return cast;
	}
	
	public void delete(Cast cast) {
		System.out.println("before repository");
		em.remove(cast);
		System.out.println("before repository");
	}
	
	public Cast find(String movieId) {
		TypedQuery<Cast> query = em.createNamedQuery("Cast.viewCast", Cast.class);
		query.setParameter("pmovieId",movieId);	
		List<Cast> castList =  query.getResultList();
		if(castList != null && castList.size() == 1) {
			return castList.get(0);
		}
		return null;
	}
	
	public Cast findCastByID(String castId) {
		TypedQuery<Cast> query = em.createNamedQuery("Cast.viewCastByID", Cast.class);
		query.setParameter("pcastId",castId);	
		List<Cast> castList =  query.getResultList();
		if(castList != null && castList.size() == 1) {
			return castList.get(0);
		}
		return null;
	}
}

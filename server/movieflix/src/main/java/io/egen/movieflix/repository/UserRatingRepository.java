package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.model.UserRating;

@Repository
public class UserRatingRepository {
	@PersistenceContext
	private EntityManager em;
	//add rating
	public UserRating add(UserRating userRating) {
		em.persist(userRating);
		 return userRating;
	}
	
	//view rating
	public List<UserRating> findAllRatings(String movieId) {
		TypedQuery<UserRating> query = em.createNamedQuery("UserRating.viewUserRatings", UserRating.class);
		query.setParameter("pmovieId",movieId);		
		List<UserRating> userRatings =  query.getResultList();
		return userRatings;	
	}
	
	//update rating
	public UserRating update(UserRating userRating) {		
		em.merge(userRating);
		return userRating;
	}
	
	//delete rating
	public void delete(UserRating userRating) {
		em.remove(userRating);
	}
	
	public void deleteAllUserRatings(List<UserRating> userRatings) {
		for(UserRating userRating : userRatings){
			em.remove(userRating);
			}
	}
	
	public UserRating findRating(String userRatingId) {
		TypedQuery<UserRating> query = em.createNamedQuery("UserRating.viewUserRating", UserRating.class);
		query.setParameter("puserRatingId",userRatingId);	
		List<UserRating> userRatings =  query.getResultList();
		if(userRatings != null && userRatings.size() == 1) {
			return userRatings.get(0);
		}
		return null;
	}
}

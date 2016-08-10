package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.model.User;

@Repository
public class UserRepository {
	@PersistenceContext
	private EntityManager em;
	
	public User create(User user) {
		em.persist(user);
		return user;
	}
	public User login(String username, String password) {
		
		TypedQuery<User> query = em.createNamedQuery("User.findUser", User.class);
		query.setParameter("pusername",username);
		query.setParameter("ppassword",password);
		
		List<User> users =  query.getResultList();
		if(users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}
	public List<User> findAll() {
			TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
			return query.getResultList();
	}
	
	public User findById(String userId) {
		TypedQuery<User> query = em.createNamedQuery("User.findUserById", User.class);
		query.setParameter("puserId",userId);
		List<User> users =  query.getResultList();
		if(users != null && users.size() == 1) {
			return users.get(0);
		}
		return null;
	}
	
	//logout implementation
}

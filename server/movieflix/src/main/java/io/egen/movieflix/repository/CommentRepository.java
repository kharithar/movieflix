package io.egen.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.model.Comment;

@Repository
public class CommentRepository {
	
	@PersistenceContext
	private EntityManager em;
	//add coment
	public Comment add(Comment comment){
			em.persist(comment);		
		return comment;
	}
	
	//view comments
	public List<Comment> find(String movieId){
		TypedQuery<Comment> query = em.createNamedQuery("Comment.viewComments", Comment.class);
		query.setParameter("pmovieId",movieId);		
		List<Comment> comments =  query.getResultList();
		return comments;
	}
	
	public Comment findComment(String commentId){
		TypedQuery<Comment> query = em.createNamedQuery("Comment.viewComment", Comment.class);
		query.setParameter("pcommentId",commentId);	
		List<Comment> comments =  query.getResultList();
		if(comments != null && comments.size() == 1) {
			return comments.get(0);
		}
		return null;
	}
	//update comment
	public Comment update(Comment comment){
		em.merge(comment);
		return comment;
	}
	//delete comment
	public void delete(Comment comment){
		em.remove(comment);
	}
	
	public void deleteAllComments(List<Comment> comments){
		for(Comment comment : comments){
		em.remove(comment);
		}
	}
}

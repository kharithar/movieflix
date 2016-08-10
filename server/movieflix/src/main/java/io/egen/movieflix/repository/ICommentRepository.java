package io.egen.movieflix.repository;

import java.util.List;

import io.egen.movieflix.model.Comment;

public interface ICommentRepository {
	
	//add coment
	public List<Comment> add(List<Comment> commentList);
	
	//view comments
	public List<Comment> find(String movieId);
	//update comment
	public Comment update(Comment comment);
	//delete comment
	public void delete(Comment comment);
	
	public void deleteAllComments(List<Comment> comments);

}

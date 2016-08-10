package io.egen.movieflix.service;

import java.util.List;

import io.egen.movieflix.model.Comment;

public interface ICommentService {
	
	//add coment
	public List<Comment> add(List<Comment> commentList);	
	//view comments
	public Comment find(String movieId);
	//update comment
	public Comment update(String movieId,Comment comment);
	//delete comment
	public void delete(String commentId);
	public void deleteAllComments(List<Comment> comments);
}

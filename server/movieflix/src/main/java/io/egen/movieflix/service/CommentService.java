package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.model.Comment;
import io.egen.movieflix.model.Movie;
import io.egen.movieflix.model.User;
import io.egen.movieflix.repository.CommentRepository;
import io.egen.movieflix.repository.MovieRepository;
import io.egen.movieflix.repository.UserRepository;
@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	UserRepository userRepository;
	//add coment	
	@Transactional
	public Comment add(Comment comment) {
		String movieId = comment.getMovie().getMovieId();
		String userId = comment.getUser().getUserId();
		Movie movie = movieRepository.findMovieById(movieId);
		User user = userRepository.findById(userId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		comment.setMovie(movie);
		comment.setUser(user);
		return commentRepository.add(comment);
	}
	
	//view comments
	public List<Comment> find(String movieId) {
		return (List<Comment>) commentRepository.find(movieId);
	}

	//update comment
	@Transactional
	public Comment update(String movieId,Comment comment) {
		String userId = comment.getUser().getUserId();
		Movie movie = movieRepository.findMovieById(movieId);
		User user = userRepository.findById(userId);
		if(movie == null){
		throw new MovieNotFoundException("Movie not found");
		}
		comment.setMovie(movie);
		comment.setUser(user);
		return commentRepository.update(comment);
	}
	//delete comment
	@Transactional
	public void delete(String commentId) {
		Comment comment = commentRepository.findComment(commentId);
		commentRepository.delete(comment);
	}
	@Transactional
	public void deleteAllComments(List<Comment> comments) {
		commentRepository.deleteAllComments(comments);
	}
	
}

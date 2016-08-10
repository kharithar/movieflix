package io.egen.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieflix.exception.MovieNotFoundException;
import io.egen.movieflix.model.Cast;
import io.egen.movieflix.model.Comment;
import io.egen.movieflix.model.IMDBRating;
import io.egen.movieflix.model.Movie;
import io.egen.movieflix.model.User;
import io.egen.movieflix.model.UserRating;
import io.egen.movieflix.repository.CommentRepository;
import io.egen.movieflix.repository.MovieRepository;
import io.egen.movieflix.repository.UserRatingRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	CastService castService;
	@Autowired
	CommentService commentService;
	@Autowired
	UserRatingService userRatingService;
	@Autowired
	IMDBRatingService imdbRatingService;
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserService userService;
	@Autowired
	UserRatingRepository userRatingRepository;
	@Transactional
	public Movie create(Movie movie){
		 Cast cast = castService.create(movie.getCast());
		 IMDBRating imdbRating = imdbRatingService.add(movie.getImdbRating());
		 User user = userService.findById(movie.getUser().getUserId());
		 movie.setUser(user);
		 movie.setImdbRating(imdbRating);
		 movie.setCast(cast);
		return movieRepository.create(movie);
	}
	
	public List<Movie> findByType(String type) {
		return movieRepository.findByType(type);		
	}
	
	public List<Movie> findByYear(int year) {
		return movieRepository.findByYear(year);		
	}
	public List<Movie> findByGenre(String genre) {
		return movieRepository.findByGenre(genre);		
	}
	@Transactional
	public Movie update(Movie movie) {
		Movie existing = movieRepository.findMovieById(movie.getMovieId());
		if(existing == null) {
			throw new MovieNotFoundException("Movie not found");
		}
	/*	if(existing.getCommentList().size() == 0) {
			movie.getCommentList().clear();
		}
		if(existing.getUserRatingList().size() == 0) {
			movie.getUserRatingList().clear();
		}*/
		//movie.setCommentList(existing.getCommentList());
		//movie.setUserRatingList(existing.getUserRatingList());
		return movieRepository.update(movie);
	}
	
	public List<Movie> sortByIMDBRatings() {
		return movieRepository.sortByIMDBRatings();
	}
	public List<Movie> sortByIMDBVotes() {
		return movieRepository.sortByIMDBVotes();
	}
	public List<Movie> sortByYear() {
		return movieRepository.sortByIMDBVotes();
	}
	@Transactional
	public void delete(String movieId) {
		Movie movie = movieRepository.findMovieById(movieId);
		if(movie == null){
			throw new MovieNotFoundException("Movie with id "+ movieId +" not found");
		}
		List<Comment> comments = commentRepository.find(movieId);
		if(comments.size() >0) {
			movie.setCommentList(comments);
			commentService.deleteAllComments(movie.getCommentList());
		}
		List<UserRating> userRatings = userRatingRepository.findAllRatings(movieId);
		if(userRatings.size() >0) {
			movie.setUserRatingList(userRatings);
			userRatingService.deleteAllUserRatings(movie.getUserRatingList());
		}

		castService.delete(movie.getCast());
		imdbRatingService.delete(movie.getImdbRating());
		movieRepository.delete(movie);
	}
}

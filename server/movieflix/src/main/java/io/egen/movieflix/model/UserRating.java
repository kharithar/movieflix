package io.egen.movieflix.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rating")
@NamedQueries({
	@NamedQuery(name="UserRating.viewUserRatings",query = "Select e from UserRating e where e.movie.movieId = :pmovieId"),
	@NamedQuery(name="UserRating.viewUserRating",query = "Select e from UserRating e where e.ratingId = :puserRatingId"),
	
})
public class UserRating {
	
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String ratingId;
	private int rating;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}

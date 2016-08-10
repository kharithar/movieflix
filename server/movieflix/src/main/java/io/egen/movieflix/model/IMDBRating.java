package io.egen.movieflix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="IMDBRating")
@NamedQueries({
	@NamedQuery(name="IMDBRating.viewIMDBRating",query = "Select e from IMDBRating e where e.movie.movieId = :pmovieId"),
	@NamedQuery(name="IMDBRating.viewIMDBRatingByID",query = "Select e from IMDBRating e where e.imId = :pimdbRatingId"),
	
})
public class IMDBRating {
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String imId;
	@Column(unique = true)
	private String imdbId;
	private float rating;
	private String imdbVotes;
	@OneToOne
	private Movie movie;
	
	
	public String getImId() {
		return imId;
	}
	public void setImId(String imId) {
		this.imId = imId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
}

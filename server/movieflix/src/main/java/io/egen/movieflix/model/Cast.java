package io.egen.movieflix.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="cast")
@NamedQueries({
	@NamedQuery(name="Cast.viewCast",query = "Select e from Cast e where e.movie.movieId = :pmovieId"),
	@NamedQuery(name="Cast.viewCastByID",query = "Select e from Cast e where e.castId = :pcastId")
})
public class Cast {
	
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String castId;
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> writer;
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> actor;
	@OneToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	
	
	public String getCastId() {
		return castId;
	}
	public void setCastId(String castId) {
		this.castId = castId;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<String> getWriter() {
		return writer;
	}
	public void setWriter(List<String> writer) {
		this.writer = writer;
	}
	public List<String> getActor() {
		return actor;
	}
	public void setActor(List<String> actor) {
		this.actor = actor;
	}

}

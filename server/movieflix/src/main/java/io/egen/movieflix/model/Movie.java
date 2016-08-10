package io.egen.movieflix.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="movie")
@NamedQueries({
	@NamedQuery(name="Movie.sortByIMDBRatings",query = "Select e from Movie e order by e.imdbRating.rating DESC"),
	@NamedQuery(name="Movie.sortByIMDBVotes",query = "Select e from Movie e order by e.imdbRating.imdbVotes DESC"),
	@NamedQuery(name="Movie.sortByYear",query = "Select e from Movie e order by e.year DESC"),
})
public class Movie {
	
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String movieId;
	private String title;
	private int year;
	private String rated;
	//private Date released;
	private String runTime;
	private String director;
	private String plot;
	private String country;
	private String awards;
	private String poster;
	private String metaScore;
	private String createdBy;
	private String movieType;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> genreList;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Cast cast;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	private IMDBRating imdbRating;
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> language;
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Comment> commentList;	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<UserRating> userRatingList;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public IMDBRating getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(IMDBRating imdbRating) {
		this.imdbRating = imdbRating;
	}
	public List<UserRating> getUserRatingList() {
		return userRatingList;
	}
	public void setUserRatingList(List<UserRating> userRatingList) {
		//this.userRatingList = userRatingList;
		if(this.userRatingList == null){
			this.userRatingList = userRatingList;
			}else{
				this.userRatingList.retainAll(userRatingList);
				this.userRatingList.addAll(userRatingList);
			}
	}
	public Cast getCast() {
		return cast;
	}
	public void setCast(Cast cast) {
		this.cast = cast;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	/*public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}*/
	public String getRunTime() {
		return runTime;
	}
	public void setRunTime(String runTime) {
		this.runTime = runTime;
	}
	public List<String> getGenreList() {
		return genreList;
	}
	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}
	public List<String> getLanguage() {
		return language;
	}
	public void setLanguage(List<String> language) {
		this.language = language;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(String metaScore) {
		this.metaScore = metaScore;
	}

	public String getMovieType() {
		return movieType;
	}
	public void setType(String movieType) {
		this.movieType = movieType;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		//this.commentList.clear();
		if(this.commentList == null){
		this.commentList = commentList;
		}else{
			this.commentList.retainAll(commentList);
			this.commentList.addAll(commentList);
		}
	}

}

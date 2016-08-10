package io.egen.movieflix.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comment")
@NamedQueries({
	@NamedQuery(name="Comment.viewComments",query = "Select e from Comment e where e.movie.movieId = :pmovieId"),
	@NamedQuery(name="Comment.viewComment",query = "Select e from Comment e where e.commentId = :pcommentId"),
})
public class Comment {
	@Id
	@GenericGenerator(name="customUUID" , strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String commentId;
	private String comments;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;
	@ManyToOne(cascade = CascadeType.ALL)
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
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}

package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_books")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "book_id")
	private int bookId;
	
	@Column(name = "api_id")
	private String apiId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	@Column(name = "review")
	private String review;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "rating")
	private Rating rating;
	
	@Column(name = "date_finished")
	private Timestamp dateFinished;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", apiId=" + apiId + ", user=" + user.getUsername() + ", review=" + review + ", rating="
				+ rating + ", dateFinished=" + dateFinished + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Timestamp getDateFinished() {
		return dateFinished;
	}

	public void setDateFinished(Timestamp dateFinished) {
		this.dateFinished = dateFinished;
	}
	
	
	
	
}
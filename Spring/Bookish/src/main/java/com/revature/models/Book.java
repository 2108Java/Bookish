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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
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
	
	
	
	
}

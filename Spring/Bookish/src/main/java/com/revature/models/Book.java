package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "user_books")
public class Book {
	
	@Id
	@GeneratedValue
	@Column(name = "book_id")
	int bookId;
	
	@Column(name = "api_id")
	String apiId;
	
	@ManyToOne
	@JoinColumn(name = "username")
	User user;
	
	@Column(name = "review")
	String review;
	
	@Column(name = "rating")
	Rating rating;
	
	@Column(name = "date_finished")
	Timestamp dateFinished;
}

package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name = "book_id")
	String bookId;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "review")
	String review;
	
	@Column(name = "rating")
	Rating rating;
	
	@Column(name = "date_finished")
	Timestamp dateFinished;
}

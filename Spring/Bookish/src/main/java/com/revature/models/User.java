package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class User {
	
	@Column(name = "username")
	String username;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "password")
	String password;
	//image
	
	List<Book> read;
	List<Book> toRead;

}

package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	//image
	
<<<<<<< HEAD
	@OneToMany(mappedBy = "user")
	List<Book> userBooks;
//	
=======
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Book> userBooks;
	
>>>>>>> 1e219574783aef2f6b99413082c8e5f75bf331e2
//	@ManyToMany
//	List<Book> toRead;

}

package com.revature.service;

import java.util.List;

import com.revature.models.Book;
import com.revature.models.User;

public interface UserService {

	//register
	User registerUser(User user);
	
	//encrypt password
	String encrypt(String password);
	
	//decrypt password
	String decrypt(String password);
		
	//login
	User authenticate(String username, String password);
	
	//update password
	boolean updatePassword(String username, String password);
	
	//get list of books
	List<Book> readList(String username);
	
	List<Book> toReadList(String username);
	
}

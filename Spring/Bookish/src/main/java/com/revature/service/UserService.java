package com.revature.service;

import java.util.List;

import com.revature.models.Book;
import com.revature.models.Message;
import com.revature.models.User;

public interface UserService {

	//register
	Message registerUser(User user);
	
	//encrypt password
	String encrypt(String password);
	
	//decrypt password
	String decrypt(String password);
		
	//login
	User authenticate(String username, String password);
	
	//update password
	Message updatePassword(String username, String password);
	
}

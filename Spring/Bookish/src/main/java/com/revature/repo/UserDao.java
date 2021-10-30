package com.revature.repo;

import com.revature.models.User;

public interface UserDao {

	//insert user
	boolean insertUser(User user);
	
	//get a user
	User selectUser(String username);
	
	//update password
	boolean updateUser(String username, String password);
	
	
}

package com.revature.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Book;
import com.revature.models.User;
import com.revature.repo.BookDao;
import com.revature.repo.UserDao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service("User Service")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao bookDao;
	
	@Override
	public String registerUser(User user) {
		String message = "";
		
		//encrypt the password before passing the user object to the dao
		String password = user.getPassword();
		password = encrypt(password);
		user.setPassword(password);
		
		if (userDao.insertUser(user)) {
			message = "Registration was successful.";
		}
		else {
			message = "Registration was unsuccessful.";	
		}
		
		return message;
	}
	@Override
	public String encrypt(String password) {
		String encrypt = Base64.getEncoder().encodeToString(password.getBytes());
		return encrypt;
	}
	@Override
	public String decrypt(String password) {
		byte[] decrypt = Base64.getDecoder().decode(password);
		password = new String(decrypt);
		return password;
	}
	
	@Override
	public User authenticate(String username, String password) {
		boolean authenticated = false;
		
		User user = userDao.selectUser(username);
		
		if(user != null) {
			if(user.getUsername() != null && user.getPassword() != null) {
				//decrypt the stored password before authenticating
				String storedPassword = user.getPassword();
				storedPassword = decrypt(storedPassword);
				
				if(user.getUsername().equals(username) && storedPassword.equals(password)) {
					authenticated = true;
				}
			}
		}
		
		if(!authenticated) {
			user = null;
		}
		
		return user;
	}
	
	@Override
	public boolean updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

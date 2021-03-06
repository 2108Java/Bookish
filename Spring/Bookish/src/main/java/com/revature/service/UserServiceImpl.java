package com.revature.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Book;
import com.revature.models.Message;
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
	public Message registerUser(User user) {
		Message message = new Message("Registration was successful.");
		
		user.setPassword(encrypt(user.getPassword()));
		
		try {
			userDao.save(user);
		}
		catch(Exception e) {
//			e.printStackTrace();
			message.setMessage("Registration was unsuccessful.");	
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
		
		User user = userDao.findByUsername(username);
		
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
	public Message updatePassword(String username, String password) {
		Message message= new Message();
		
		if (userDao.updatePassword(username,encrypt(password)) > 0) {
			message.setMessage("Update Password was successful.");
		}
		else {
			message.setMessage("Update Password was unsuccessful.");	
		}
		
		return message;
	}

}

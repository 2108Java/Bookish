package com.revature.service;

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
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encrypt(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> readList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> toReadList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}

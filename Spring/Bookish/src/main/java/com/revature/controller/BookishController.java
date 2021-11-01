package com.revature.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.models.Message;
import com.revature.models.Rating;
import com.revature.models.User;
import com.revature.service.BookService;
import com.revature.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class BookishController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	//Register - post
	@PostMapping(value = "/register")
	public Message registerUser(@RequestBody User user) {
		
		Message message = userService.registerUser(user);
		return message;
	}
	
	//Login - post
	@PostMapping(value = "/login")
	public User login(@RequestBody User user, HttpSession session) {

		String username = user.getUsername();
		String password = user.getPassword();
		
		user = userService.authenticate(username, password);
		
		if(user != null) {
			session.setAttribute("username", user.getUsername());
		}
		
		return user;
	}
	
	//Validate - get
	@GetMapping(value = "/session")
	public boolean checkSession(HttpSession session) {
		boolean activeSession = false;
		
		if(session.getAttribute("username") != null) {
			activeSession = true;
		}
		
		return activeSession;
	}
	
	//Logout - get
	@GetMapping(value = "/logout")
	public Message logout(HttpSession session) {
		Message message = new Message("Logout failed.");
		
		session.setAttribute("username", null);
		if(session.getAttribute("username") == null) {
			message.setMessage("Logout succeeded.");
		}
		
		return message;
	}
	
	//Update password - put
	@PutMapping(value = "/password")
	public Message updatePassword(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		Message message = userService.updatePassword(username,password);
		
		return message;
	}
	
	//Update list - put
	@PutMapping(value = "/list")
	public Message updateReadList(@RequestBody User user) {
		Message message = new Message("Book list not updated.");
		
		if(bookService.updateBookList(user)) {
			message.setMessage("Book list successfully updated.");
		}
		
		return message;
	}
	
}

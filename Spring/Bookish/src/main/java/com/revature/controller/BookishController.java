package com.revature.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.models.Rating;
import com.revature.models.User;
import com.revature.service.BookService;
import com.revature.service.UserService;

@RestController
@RequestMapping("/api")
public class BookishController {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	//Register - post
	@PostMapping(value = "/register")
	public String registerUser(@RequestBody User user) {
		String message = " ";
		message = userService.registerUser(user);
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
	public String logout(HttpSession session) {
		String message = "Logout failed.";
		
		session.setAttribute("username", null);
		if(session.getAttribute("username") == null) {
			message = "Logout succeeded.";
		}
		
		return message;
	}
	
	//Update password - put
	@PutMapping(value = "/password")
	public String updatePassword(@RequestBody String password, HttpSession session) {
		String username1 = (String) session.getAttribute("username");
		String message = userService.updatePassword(username1,password);
		
		return message;
	}
	
	//Update list - put
	@PutMapping(value = "/list")
	public String updateReadList(@RequestBody User user) {
		String message = "Book list not updated.";
		
		if(bookService.updateBookList(user)) {
			message = "Book list successfully updated.";
		}
		
		return message;
	}
	
}

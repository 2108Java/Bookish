package com.revature.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

@RestController
@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RequestMapping("/api/")
public class BookishController {

	/**
	 * create fake list for testing endpoints
	 */
	private User testUser;
	private List<Book> bookList;
	
	public void initializeFakeData() {
		testUser = new User("test_user", "test@test.com", "password", bookList);
		bookList = new ArrayList<>();
		
		bookList.add(new Book(1, "mvmGPgAACAAJ", "test_user", "Fake review", Rating.ZERO, new Timestamp(System.currentTimeMillis())));
		bookList.add(new Book(2, "ZCtfCgAAQBAJ", "test_user", "another fake review", Rating.FIVE, new Timestamp(System.currentTimeMillis())));
		bookList.add(new Book(3, "JEYCDAAAQBAJ", "test_user", "fake review number 3", Rating.THREE, new Timestamp(System.currentTimeMillis())));
		
		bookList.add(new Book(4, "sJsqDwAAQBAJ", "test_user", null, null, null));
		bookList.add(new Book(5, "hQc8zgEACAAJ", "test_user", null, null, null));
		bookList.add(new Book(6, "mOrSAwAAQBAJ", "test_user", null, null, null));
	}
	
	//Register - post
	@PostMapping(value = "/register")
	public Message registerUser(@RequestBody User user) {
		Message message = new Message("");
		
		if(user != null) {
			message.setMessage("Registration for " + user.getUsername() + "was successful.");
		}
		else {
			message.setMessage("Registration was unsuccessful.");
		}
		
		return message;
	}
	
	//Login - post
	@PostMapping(value = "/login")
	public User login(@RequestBody User user, HttpSession session) {
		initializeFakeData();
		
		if(user.getUsername() != null && user.getPassword() != null) {
			if(testUser.getUsername().equals(user.getUsername()) && testUser.getPassword().equals(user.getPassword())) {
				session.setAttribute("username", user.getUsername());
			}
		}
		else {
			testUser = null;
		}
		
		
		return testUser;
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
	public Message updatePassword(@RequestBody String password) {
		Message message = new Message("Password not updated.");
		
		testUser.setPassword(password);
		if(testUser.getPassword().equals(password)) {
			message.setMessage("Password updated successfully.");
		}
		
		return message;
	}
	
	//Update list - put
	@PutMapping(value = "/list")
	public Message updateReadList(@RequestBody List<Book> updateRead) {
		Message message = new Message("Read list not updated.");
		
		bookList = updateRead;
		if(bookList == updateRead) {
			message.setMessage("Read list updated.");
		}
		
		return message;
	}
	
//	@PutMapping(value = "/list/toRead")
//	public String updateToReadList(@RequestBody List<Book> updateToRead) {
//		String message = "To read list not updated.";
//		
//		toRead = updateToRead;
//		if(toRead == updateToRead) {
//			message = "list updated.";
//		}
//		
//		return message;
//	}

	
}

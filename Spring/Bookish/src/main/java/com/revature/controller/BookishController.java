package com.revature.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.models.Rating;
import com.revature.models.User;

@RestController
@RequestMapping("/api/")
public class BookishController {

	/**
	 * create fake list for testing endpoints
	 */
	private static User testUser;
	private static List<Book> read;
	private static List<Book> toRead;
	
	public static void initializeFakeData() {
		testUser = new User("test_user", "test@test.com", "password", read, toRead);
		
		
		read.add(new Book("mvmGPgAACAAJ", "test_user", "Fake review", Rating.ZERO, new Timestamp(System.currentTimeMillis())));
		read.add(new Book("ZCtfCgAAQBAJ", "test_user", "another fake review", Rating.FIVE, new Timestamp(System.currentTimeMillis())));
		read.add(new Book("JEYCDAAAQBAJ", "test_user", "fake review number 3", Rating.THREE, new Timestamp(System.currentTimeMillis())));
		
		toRead.add(new Book("sJsqDwAAQBAJ", "test_user", null, null, null));
		toRead.add(new Book("hQc8zgEACAAJ", "test_user", null, null, null));
		toRead.add(new Book("mOrSAwAAQBAJ", "test_user", null, null, null));
	}
	
	//Register - post
	@PostMapping(value = "/register")
	public String registerUser(@RequestBody User user) {
		String message = "";
		
		if(user != null) {
			message = "Registration for " + user.getUsername() + "was successful.";
		}
		else {
			message = "Registration was unsuccessful.";
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
	public String updatePassword(@RequestBody String password) {
		String message = "Password not updated.";
		
		testUser.setPassword(password);
		if(testUser.getPassword().equals(password)) {
			message = "Password updated successfully.";
		}
		
		return message;
	}
	
	//Update list - put
	@PutMapping(value = "/list")
	public String updateReadList(@RequestBody List<Book> updateRead) {
		String message = "Read list not updated.";
		
		read = updateRead;
		if(read == updateRead) {
			message = "Read list updated.";
		}
		
		return message;
	}
	
	@PutMapping(value = "/list/toRead")
	public String updateToReadList(@RequestBody List<Book> updateToRead) {
		String message = "To read list not updated.";
		
		toRead = updateToRead;
		if(toRead == updateToRead) {
			message = "list updated.";
		}
		
		return message;
	}

	
}

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
	
	/**
	 * create fake list for testing endpoints
	 */
	private static User testUser;
	private static List<Book> userBooks;
	
	public static void initializeFakeData() {
		testUser = new User("test_user", "test@test.com", "password", userBooks);
		
		
//		userBooks.add(new Book(0, "mvmGPgAACAAJ", testUser, "Fake review", Rating.ZERO, new Timestamp(System.currentTimeMillis())));
//		userBooks.add(new Book(0, "ZCtfCgAAQBAJ", testUser, "another fake review", Rating.THREE, new Timestamp(System.currentTimeMillis())));
//		userBooks.add(new Book(0, "JEYCDAAAQBAJ", testUser, "fake review number 3", Rating.FIVE, new Timestamp(System.currentTimeMillis())));
//		
//		userBooks.add(new Book(0, "sJsqDwAAQBAJ", testUser, null, null, null));
//		userBooks.add(new Book(0, "hQc8zgEACAAJ", testUser, null, null, null));
//		userBooks.add(new Book(0, "mOrSAwAAQBAJ", testUser, null, null, null));
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
	public String updateReadList(@RequestBody User user) {
		String message = "Book list not updated.";
		
//		userBooks = updateBookList;
//		if(userBooks == updateBookList) {
//			message = "Book list updated.";
//		}
		if(bookService.updateBookList(user)) {
			message = "Book list successfully updated.";
		}
		
		return message;
	}
	
}

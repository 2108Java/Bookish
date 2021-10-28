package com.revature.service;

import java.util.List;

import com.revature.models.Book;
import com.revature.models.User;

public interface BookService {

	//add a new book
	boolean addBook(Book book);
	
	//retrieve a book
	Book getBook(String api_id, String username);
	
	//update a book list
	//will replace current list with updated list
	//uses bookDao deleteBookList and insertBookList
	boolean updateBookList(User user);
	
	//List<Book> getBook(String titleOrAuthor);//by title or author
}

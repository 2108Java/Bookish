package com.revature.service;

import java.util.List;

import com.revature.models.Book;

public interface BookService {

	//add a new book
	boolean addBook(Book book);
	
	//retrieve a book
	Book getBook(String id);//by id
	
	//update a book
	boolean updateBook(Book book);
	
	//List<Book> getBook(String titleOrAuthor);//by title or author
}

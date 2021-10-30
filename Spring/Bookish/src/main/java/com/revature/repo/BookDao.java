package com.revature.repo;

import java.util.List;

import com.revature.models.Book;

public interface BookDao {

	//insert book
	boolean insertBook(Book book);
	
	//get book
	Book selectBook(String id);//by id
	
	//update book
	//rate a book
	//review a book
	//finish a book
	boolean updateUserBook(Book book);
	
	//List<Book> selectBook(String nameOrAuthor);//by name or author
	
}

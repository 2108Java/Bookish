package com.revature.repo;

import java.util.List;

import com.revature.models.Book;
import com.revature.models.User;

public interface BookDao {

	//insert book
	boolean insertBook(Book book);
	
	//get book list
	List<Book> selectBookList(User user); //get a users list of books
	
	//update book
	//rate a book
	//review a book
	//finish a book
	boolean insertBookList(List<Book> newBookList);
	
	boolean deleteBookList(List<Book> oldBookList);
	
	//List<Book> selectBook(String nameOrAuthor);//by name or author
	
}

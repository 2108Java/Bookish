package com.revature.repo;

import java.util.List;

import com.revature.models.Book;

public interface BookDao {

	//insert book
	boolean insertBook(Book book);
	
	//get book list
	List<Book> selectBookList(String username); //get a users list of books
	
	//update book
	//rate a book
	//review a book
	//finish a book
	boolean insertBookList(List<Book> newBookList);
	
	boolean deleteBookList(List<Book> oldBookList);
	
	//List<Book> selectBook(String nameOrAuthor);//by name or author
	
}

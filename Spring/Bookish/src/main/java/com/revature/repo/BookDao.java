package com.revature.repo;

import java.sql.Timestamp;

import com.revature.models.Book;
import com.revature.models.Rating;
import com.revature.models.UserBook;

public interface BookDao {

	//insert book
	boolean insertBook(Book book);
	
	//get book
	Book selectBook(int id);//by id
	
	Book selectBook(String nameOrAuthor);//by name or author
	
}

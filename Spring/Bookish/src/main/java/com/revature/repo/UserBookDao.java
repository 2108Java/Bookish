package com.revature.repo;

import com.revature.models.UserBook;

public interface UserBookDao {

	//rate a book
	//review a book
	//finish a book
	boolean updateUserBook(UserBook book);
}

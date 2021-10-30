package com.revature.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Book;
import com.revature.models.User;

@Transactional
@Repository("bookDao")
public interface BookDao extends JpaRepository<Book, Integer>{

	
	//insert book
	//update book
	//rate a book
	//review a book
	//finish a book
	
	//get book list
	List<Book> findByUser(User user); //get a users list of books
	
}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Book;
import com.revature.models.User;
import com.revature.repo.BookDao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	public boolean updateBookList(User user) {
		boolean success = false;
		
		List<Book> oldBookList = bookDao.findByUser(user);
		List<Book> newBookList = user.getUserBooks();
		
		//ensure the user/username is not null before processing the list
		for(Book book: newBookList) {
			book.setUser(user);
		}
		
		System.out.println(newBookList);
		//check if the user already has books stored
		if(oldBookList == null) {
			//check if the user is going to store any books
			if(newBookList != null) {
				for(Book book: newBookList) {
					bookDao.save(book);
				}
				success = true;
			}
			else if(newBookList == null){
				success = true;
			}
		}
		//ensure currently stored books are deleted
		else if(oldBookList != null) {
			bookDao.deleteAllInBatch(oldBookList);
			//check if the user is going to store any books
			if(newBookList != null) {
				for(Book book: newBookList) {
					bookDao.save(book);
				}
				success = true;
			}
			else if(newBookList == null) {
				success = true;
			}
		}
				
		return success;
	}

}

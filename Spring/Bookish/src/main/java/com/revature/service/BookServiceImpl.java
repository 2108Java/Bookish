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

//	@Override
//	public boolean addBook(Book book) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public Book getBook(String api_id, String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public boolean updateBookList(User user) {
		boolean success = false;
		
		List<Book> oldBookList = bookDao.selectBookList(user);
		List<Book> newBookList = user.getUserBooks();
		
		if(bookDao.deleteBookList(oldBookList)) {
			if(bookDao.insertBookList(newBookList)) {
				success = true;
			}
		}
		
		return success;
	}

}

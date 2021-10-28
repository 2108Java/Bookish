package com.revature.service;

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
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book getBook(String api_id, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBookList(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}

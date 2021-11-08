package com.revature.service;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.revature.repo.BookDao;

public class BookServiceTest {

	@Mock
	private BookDao bookDao;
	
	private BookService bookService;
	
	@Before
	void setup() {
		bookDao = mock(BookDao.class);
		
		bookService = new BookServiceImpl(bookDao);
	}
	
	@Test
	void updateBookList() {
		//this method returns a boolean
		//this method takes a user object as a parameter
	}
}

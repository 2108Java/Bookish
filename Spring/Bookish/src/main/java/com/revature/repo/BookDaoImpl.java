package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Book;

@Repository("bookDao")
@Transactional
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean insertBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> selectBookList(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBookList(List<Book> newBookList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBookList(List<Book> oldBookList) {
		// TODO Auto-generated method stub
		return false;
	}

	

}

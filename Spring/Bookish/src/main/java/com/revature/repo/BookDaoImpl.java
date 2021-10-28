package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Book;
import com.revature.models.User;

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
	public List<Book> selectBookList(User user) {
		
		String hql = "from Book where user = '" + user + "'";
		
		List<Book> bookList = sessionFactory.openSession().createQuery(hql, Book.class).list();
		
		return bookList;
	}

	@Override
	public boolean insertBookList(List<Book> newBookList) {
		
		for(Book book: newBookList) {
			sessionFactory.openSession().persist(book);
		}
		return true;
	}

	@Override
	public boolean deleteBookList(List<Book> oldBookList) {
		
		for(Book book: oldBookList) {
			sessionFactory.openSession().delete(book);
		}
		
		return true;
	}

	

}

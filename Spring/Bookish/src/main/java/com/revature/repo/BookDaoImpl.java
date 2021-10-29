package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		boolean success = true;
		
		try(Session session = sessionFactory.openSession()){
			Transaction tx = session.beginTransaction();
			
			session.save(book);
			
			tx.commit();
		}
		catch(Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Book> selectBookList(User user) {
		List<Book> bookList = null;
		
		try(Session session = sessionFactory.openSession()){
			String hql = "from Book where user = '" + user + "'";
			
			bookList = session.createQuery(hql, Book.class).list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bookList;
	}

	@Override
	public boolean insertBookList(List<Book> newBookList) {
		boolean success = true;
		
		try(Session session = sessionFactory.openSession()){
			Transaction tx = session.beginTransaction();
		
			for(Book book: newBookList) {
				session.save(book);
			}
		
			tx.commit();
		} 
		catch(Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean deleteBookList(List<Book> oldBookList) {
		boolean success = true;
		
		try(Session session = sessionFactory.openSession()){
			Transaction tx = session.beginTransaction();
		
			for(Book book: oldBookList) {
				session.delete(book);
			}
		
			tx.commit();
		}
		catch(Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	

}

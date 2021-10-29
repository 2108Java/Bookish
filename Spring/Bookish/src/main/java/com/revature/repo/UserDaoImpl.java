package com.revature.repo;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean insertUser(User user) {
		
		boolean check = true;
		
		try(Session ses = sessionFactory.openSession()){
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(user);
		
		tx.commit();
		
		ses.close();
		
		} catch(Exception e) {
			check = false;
			e.printStackTrace();
		}
		return check;
	}
	
	@Override
	public User selectUser(String username) {
		User user = null;
		
		try(Session session = sessionFactory.openSession()){
			user = session.get(User.class, username);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean updateUser(String username, String password) {
		return false;
	}

}

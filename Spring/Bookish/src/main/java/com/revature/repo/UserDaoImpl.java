package com.revature.repo;

<<<<<<< HEAD
import org.hibernate.Session;
=======
>>>>>>> 1e219574783aef2f6b99413082c8e5f75bf331e2
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
<<<<<<< HEAD
		
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
		
//		sessionFactory.openSession().save(user);
		return check;
	
=======
		return false;
>>>>>>> 1e219574783aef2f6b99413082c8e5f75bf331e2
	}
	
	@Override
	public User selectUser(String username) {
		
		User user = sessionFactory.openSession().get(User.class, username);// this fixes the EntityManagerFactory is closed error
//		sessionFactory.close();
		
//		User user = sessionFactory.getCurrentSession().get(User.class, username); // this throws No CurrentSessionContext configured
		return user;
	}

	@Override
	public boolean updateUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

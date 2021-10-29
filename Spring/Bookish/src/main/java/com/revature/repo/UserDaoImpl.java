package com.revature.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
		
//		sessionFactory.openSession().save(user);
		return check;
	
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
		System.out.println("Repository");
		boolean check = true;
		try(Session ses = sessionFactory.openSession()){
			Transaction tx = ses.beginTransaction();
			User user = ses.load(User.class, username);
			System.out.println(ses.load(User.class, username));
			user.setPassword(password);
	        ses.update(user);
	        tx.commit();
	        ses.close();
			} catch(Exception e) {
				check = false;
				e.printStackTrace();
			}
		return check;
			
	}

}

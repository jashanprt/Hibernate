package com.hibernate.dao;

import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.User;

public class UserManager2 {

	public static void main(String[] args) {

		User u = new User();
		u.setUsername("TestUser");
		u.setPassword("admin");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
		///	User newu = (User) s.get(User.class, 1);
		///	System.out.println("Show: "+newu.getUsername());
			
			s.save(u);
		//	s.persist(u);
		/*	
			String hql="FROM User";
			Query q=s.createQuery(hql);
			@SuppressWarnings("rawtypes")
			java.util.List l= q.list();
			@SuppressWarnings("rawtypes")
			ListIterator i=l.listIterator();
			while(i.hasNext())
			{
				User usr=(User)i.next();
				System.out.println("Show Part 2: "+usr.getUsername());
				
			}/**/
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}

	}

	public void add(User u) {
	}

	public void deleteLast(int id) {
	}

	public void updateEntry(User u, int id) {
	}

	public User getEntry() {
		return null;
	}
}

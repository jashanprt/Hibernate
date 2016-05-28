package com.hibernate.dao;

import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.User;

public class UserManager {

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		User u = new User();
		u.setUsername("Forst");
		u.setPassword("admin");
		UserManager um = new UserManager();
		um.add(u);
		um.getAllEntry();
		um.updateEntry(u, 1);
		um.getAllEntry();
		um.delete(5);
		um.getAllEntry();

	}

	public void add(User u) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.persist(u);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public void delete(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			User newu = (User) s.get(User.class, id);
			s.delete(newu);
			System.out.println("Show: " + newu.getUsername());
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public void updateEntry(User u, int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			User newu = (User) s.get(User.class, id);
			newu.setPassword("G");
			s.update(newu);
			System.out.println("Show: " + newu.getUsername());
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public void getEntry() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			User newu = (User) s.get(User.class, 1);
			System.out.println("Show: " + newu.getUsername());
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}

	public void getAllEntry() {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			String hql = "FROM User";
			Query q = s.createQuery(hql);
			@SuppressWarnings("rawtypes")
			java.util.List l = q.list();
			@SuppressWarnings("rawtypes")
			ListIterator i = l.listIterator();
			int count=0;
			while (i.hasNext()) {
				count++;
				User usr = (User) i.next();
				System.out.println("Show Part "+count+": " + usr.getUsername());

			}
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			s.close();
		}
	}
}

package com.hibernate.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Address;
import com.hibernate.entity.Laptop;
import com.hibernate.entity.Roles;
import com.hibernate.entity.User;
import com.hibernate.entity.UserDetails;
import com.hibernate.entity.Vehicle;

public class UserDetailsManager {

	SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		UserDetails u = new UserDetails();
		u.setUsername("Forst");
		u.setPassword("admin");
		u.setGender('M');
		u.setFirst_Name("Rahul");
		u.setLast_Name("Seth");
		u.setMaritalStatus(false);
		
		Date d=new Date();
		List<Long> phone=new ArrayList<Long>();
		phone.add(Long.parseLong("8860651403"));
		phone.add(Long.parseLong("8860651491"));
		u.setPh_no(phone);
		
		Address a=new Address();
		a.setCity("Patiala");
		a.setCountry("India");
		a.setHouse_no(848);
		a.setPincode(147001);;
		a.setState("Punjab");
		a.setStreet_no(8);
		a.setTown("GNN");
		u.setAddr(a);
		
		Vehicle v=new Vehicle();
		v.setName("Muscle");
		u.setTrans(v);
		
		Laptop l1=new Laptop();
		l1.setCompanyName("DELL");
		Laptop l2=new Laptop();
		l2.setCompanyName("HP");
		u.getLapi().add(l1);
		u.getLapi().add(l2);
		
		Roles r=new Roles();
		r.setRoleName("Admin");
		r.getAccessApps().add("Portal");
		r.getAccessApps().add("Mosa");
		r.getAccessApps().add("Tibco");
		r.getAccessApps().add("Desktop");
		r.getUl().add(u);
		
		Roles r1=new Roles();
		r1.setRoleName("Users");
		r1.getAccessApps().add("Desktop");
		r1.getUl().add(u);
		
		u.getRol().add(r1);
		u.getRol().add(r);
		
		
		UserDetailsManager um = new UserDetailsManager();
		um.add(u,v,l1,l2,r,r1);
		//um.getAllEntry();
	//	um.updateEntry(u, 1);
	//	um.getAllEntry();
	//	um.delete(5);
	//	um.getAllEntry();

	}

	public void add(UserDetails u,Vehicle v,Laptop l1,Laptop l2,Roles r,Roles r1) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		try {
			s.persist(u);
			s.persist(v);
			s.persist(l1);
			s.persist(l2);
			s.persist(r);
			s.persist(r1);
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

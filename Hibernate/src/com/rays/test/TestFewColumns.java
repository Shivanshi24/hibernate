package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestFewColumns {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("select u.id, u.firstName from UserDTO u");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			Object[] dto = (Object[]) it.next();
			
			System.out.println(dto[0]);
			System.out.println("\t" + dto[1]);
			
		}

		tx.commit();
		session.close();

	}

}

package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestHQLJoin {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query q = session.createQuery(
				"select u.id, u.firstName, u.lastName, u.loginId, u.password, u.dob, u.address, m.id, m.rollNo"
				+ " from UserDTO u, MarksheetDTO m where u.id = m.id");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object[] dto = (Object[]) it.next();

			for (int i = 0; i < dto.length; i++) {

				System.out.print(dto[i] + "\t");

			}
			System.out.println();

		}

		tx.commit();
		session.close();

	}

}

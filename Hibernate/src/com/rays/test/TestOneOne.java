package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.oneone.Address;
import com.rays.oneone.Employee;

public class TestOneOne {

	public static void main(String[] args) {

		Address empaddress = new Address();
		empaddress.setId(1);
		empaddress.setStreet("Street1");
		empaddress.setCity("indore");

		Employee e = new Employee();
		e.setId(1);
		e.setName("abc");
		e.setEmpAddress(empaddress);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(e);

		tx.commit();

		session.close();

	}

}

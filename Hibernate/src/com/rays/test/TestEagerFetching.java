package com.rays.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;

public class TestEagerFetching {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);

		tx.commit();

		session.close();
	}

}

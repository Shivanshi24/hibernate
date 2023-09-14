package com.rays.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;
import com.rays.auction.Bids;

public class TestTransientPersistent {

	public static void main(String[] args) {

		Bids bid = new Bids();
		bid.setId(4);
		bid.setAmount(4000);
		bid.setTimeStamp("AAAA");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);

		Set s = item.getBids();

		s.add(bid);

		tx.commit();

		session.close();

	}

}

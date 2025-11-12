package com.hibernate.Queries;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.Mobile;

public class Insert {
    public static void main(String[] args) {
        Session session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        
        Transaction txn = session.beginTransaction();

        NativeQuery<Mobile> q = session.createNativeQuery("insert into mobile values(?,?,?)");
        q.setParameter(1, 3);
        q.setParameter(2, "9421209201");
        q.setParameter(3, 2);

        System.out.println(q.executeUpdate());

        txn.commit();
        session.close();

    }
}

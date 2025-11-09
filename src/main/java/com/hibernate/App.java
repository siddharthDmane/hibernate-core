package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Ramesh", 'M');

        SessionFactory sessionFactory = new Configuration()
        .addAnnotatedClass(com.hibernate.Student.class)
        .configure("hibernate.cfg.xml")
        .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();

        session.persist(s1);
        txn.commit();

        session.close();
        sessionFactory.close();
    }
}

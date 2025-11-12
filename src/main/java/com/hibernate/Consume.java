package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Consume {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();

        //HQL Language
        List<Student> hqlStudents = session.createQuery("from Student",Student.class).list();

        for(Student s : hqlStudents)
            System.out.println(s);

        //Native/ Usual SQL Language
        // List<Object[]> nativeStudents = session.createNativeQuery("select s.address_id, a.* from student s inner join address a on s.address_id=a.id").list();

        // for(Object[] s : nativeStudents)
        //     for(Object o : s)
        //         System.out.print(o+", ");

        txn.commit();
        session.close();
        factory.close();

    }
}

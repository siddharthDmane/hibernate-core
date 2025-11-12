package com.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.DTO.studentMobile;

public class Consume {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();

        // HQL Language
        // List<Student> hqlStudents = session.createQuery("from
        // Student",Student.class).list();

        // for(Student s : hqlStudents)
        // System.out.println(s);

        // Native/ Usual SQL Language
        List<Student> nativeStudents = session.createNativeQuery("select * from student",Student.class).list();

        for(Student s : nativeStudents)
            System.out.print(s);

        // Parameterized Native Query
        // List <Object[]> obj = session.createNativeQuery("select s.address_id, s.name from student s where id = ?")
        // .setParameter(1, 2)
        // .getResultList();

        // System.out.println(obj.get(0)[0]+", "+obj.get(0)[1]);

        // txn.commit();
        session.close();
        factory.close();

    }
}

package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Student s1 = new Student();
        Course c1 = new Course();
        Course c2 = new Course();
        Address a1 = new Address();
        Mobile m1 = new Mobile();
        List<Mobile> mobiles = new ArrayList<Mobile>();
        List<Course> courses = new ArrayList<Course>();

        // Address
        a1.setCity("Satara");
        a1.setState("Maharastra");
        a1.setPincode("412801");

        // Course
        c1.setName("Spring");
        c1.setCredit('4');
        c1.setDuration('6');

        c2.setName("Hibernate");
        c2.setCredit('4');
        c2.setDuration('6');        

        // student
        s1.setName("Ramesh");
        s1.setGender('M');
        s1.setAddress(a1);
            courses.add(c1);
            courses.add(c2);
        s1.setCourses(courses);

        // mobile
        m1.setMobileNo("9209010848");
        m1.setStudent(s1);

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction txn = session.beginTransaction();

        session.persist(a1);
        session.persist(c1);
        session.persist(c2);
        session.persist(s1);
        session.persist(m1);

        txn.commit();

        session.close();
        sessionFactory.close();
    }
}

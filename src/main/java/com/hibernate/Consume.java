package com.hibernate;

import java.util.ArrayList;
import java.util.List;

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
        // List<Student> hqlStudents = session.createQuery("from Student",Student.class).list();

        // for(Student s : hqlStudents)
        //     System.out.println(s);

        // Native/ Usual SQL Language
        // List<Student> nativeStudents = session.createNativeQuery("select * from student",Student.class).list();

        // for(Student s : nativeStudents)
        //     System.out.print(s);

        // Parameterized Native Query
        // List <Object[]> obj = session.createNativeQuery("select s.address_id, s.name from student s where id = ?")
        // .setParameter(1, 2)
        // .getResultList();

        // System.out.println(obj.get(0)[0]+", "+obj.get(0)[1]);

        // use of student-mobile dto
        NativeQuery<Object[]> q = session.createNativeQuery("select s.id,s.name,s.gender,m.id,m.mobileNo from student s inner join mobile m on s.id = m.id");
        List<Object[]> obj = q.getResultList();

        List<studentMobile> sms = new ArrayList<>();

        studentMobile temp = null;
        List<Mobile> tempMobiles = new ArrayList<>();
        int cnt;

        for(Object[] ob : obj){
            cnt = 0;
            temp = new studentMobile();
            temp.setsId((int)ob[cnt]); cnt++;
            temp.setsName((String)ob[cnt]); cnt++;
            temp.setsGender((char)ob[cnt]); cnt++;

            Mobile tempMobile = new Mobile();
            tempMobile.setId((int)ob[cnt]); cnt++;
            tempMobile.setMobileNo((String)ob[cnt]);
            
            tempMobiles.add(tempMobile);

            temp.setsMobiles(tempMobiles);
        }

        System.out.println(temp);

        txn.commit();
        session.close();
        factory.close();

    }
}

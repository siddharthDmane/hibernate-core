package com.hibernate.Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.Mobile;
import com.hibernate.DTO.studentMobile;

public class Consumer {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction txn = session.beginTransaction();
        
        // use of student-mobile dto
        NativeQuery<Object[]> q = session.createNativeQuery(
                "select s.id,s.name,s.gender,m.id,m.mobileNo from student s inner join mobile m on s.id = m.student_id");
        List<Object[]> obj = q.getResultList();

        Map<Integer, studentMobile> studentsMap = new HashMap<>();
        Map<Integer, List<Mobile>> mobilesMap = new HashMap<>();

        studentMobile temp = null;
        Mobile tempMobile = null;
        int cnt;

        for (Object[] ob : obj) {
            cnt = 3;
            if (studentsMap.get((Integer) ob[0]) == null) { 
                cnt = 0;
                temp = new studentMobile();
                temp.setsId((int) ob[cnt]); cnt++;
                temp.setsName((String) ob[cnt]);    cnt++;
                temp.setsGender((char) ob[cnt]);    cnt++;
                studentsMap.put(temp.getsId(), temp);
            }

            if (mobilesMap.get((Integer) ob[0]) == null) {
                mobilesMap.put((Integer) ob[0], new ArrayList<Mobile>());
            }

            tempMobile = new Mobile();
            tempMobile.setId((int) ob[cnt]);    cnt++;
            tempMobile.setMobileNo((String) ob[cnt]);

            List<Mobile> tempMobiles = mobilesMap.get((Integer) ob[0]);
            tempMobiles.add(tempMobile);

            mobilesMap.put((Integer) ob[0], tempMobiles);
            studentsMap.get((Integer)ob[0]).setsMobiles(tempMobiles);;
        }

        for(Map.Entry<Integer, studentMobile> res : studentsMap.entrySet())
            System.out.println(res.getValue());

        txn.commit();
        session.close();
        factory.close();
    }
    
}

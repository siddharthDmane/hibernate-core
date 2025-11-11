package com.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mobile_seq")
    @SequenceGenerator(name="mobile_seq", sequenceName = "mobile_seq", allocationSize = 1)
    public int id;
    public String mobileNo;

    @ManyToOne
    @JoinColumn(name = "student_id")
    public Student student;

    // constructor
    public Mobile() {   }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mobile [id=" + id + ", mobileNo=" + mobileNo + ", student=" + student + "]";
    }

}

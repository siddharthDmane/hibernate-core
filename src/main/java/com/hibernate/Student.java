package com.hibernate;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stud_seq")
    @SequenceGenerator(name = "stud_seq", sequenceName = "stud_seq", allocationSize = 1)
    public int id;
    public char gender;
    public String name;

    @OneToMany(mappedBy = "student")
    public List<Mobile> mobileNumbers;

    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    public List<Course> courses;

    @OneToOne
    @JoinColumn(name = "address_id")
    public Address address;

    // constructor
    public Student() {  }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setMobileNumbers(List<Mobile> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public List<Mobile> getMobileNumbers() {
        return mobileNumbers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", gender=" + gender + ", name=" + name + ", mobileNumbers=" + mobileNumbers
                + ", courses=" + courses + ", address=" + address + "]";
    }

}

package com.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    public int id;
    public char gender;
    public String name;

    // constructors
    public Student() {
    }

    public Student(int id, String name, char gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

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
}

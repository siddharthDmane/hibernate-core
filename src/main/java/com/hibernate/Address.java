package com.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq",allocationSize = 1)
    public int id;
    public String City;
    public String State;
    public String Pincode;

    // constructor
    public Address() {  }

    public Address(int id, String city, String state, String pincode) {
        this.id = id;
        City = city;
        State = state;
        Pincode = pincode;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", City=" + City + ", State=" + State + ", Pincode=" + Pincode + "]";
    }

}

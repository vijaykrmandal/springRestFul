package com.example.demo.model;

//import lombok.AllArgsConstructor;
import lombok.Data;


public @Data class Persons
 {
    private int Personid;
    private String LastName;
    private String FirstName;
    private int Age;

    public int getPersonid() {
        return Personid;
    }

    public void setPersonid(int personid) {
        Personid = personid;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Persons(int personid, String lastName, String firstName, int age) {
        Personid = personid;
        LastName = lastName;
        FirstName = firstName;
        Age = age;
    }

    public Persons(String lastName, String firstName, int age) {
        LastName = lastName;
        FirstName = firstName;
        Age = age;
    }

    public Persons() {
    }
}

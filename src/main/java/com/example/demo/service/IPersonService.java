package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Persons;

public interface IPersonService {
    public List<Persons> findAll();
    public Persons findById(int id);
    public void addPersons(Persons person);
    public void updatePersons(Persons person);
    public void removePerson(int id);


}

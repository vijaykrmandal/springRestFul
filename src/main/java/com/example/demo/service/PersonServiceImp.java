package com.example.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.example.demo.model.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class PersonServiceImp implements IPersonService {

    @Autowired
    DataSource dataSource;
    
    NamedParameterJdbcTemplate jmt;
   @PostConstruct
  public void setup() {
	 jmt=new NamedParameterJdbcTemplate(dataSource);
  }
    @Override
    public List<Persons> findAll() {
        String sql="select * from Persons";
        List<Persons> persons=jmt.query(sql, new BeanPropertyRowMapper<>(Persons.class));
        return persons;

    }
    @Override
    public Persons findById(int id) {
        String sql="Select * from Persons where Personid=:id";
        MapSqlParameterSource parameters=new MapSqlParameterSource();
        parameters.addValue("id", id);
        Persons persons=jmt.queryForObject(sql,parameters, new BeanPropertyRowMapper<>(Persons.class));
        return persons;
    }

    @Override
    public void addPersons(Persons person) {
        String sql="INSERT INTO Persons (FirstName,LastName,Age) VALUES (:firstName,:lastName,:age)";
        MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("firstName",person.getFirstName());
        parameter.addValue("lastName",person.getLastName());
        parameter.addValue("age",person.getAge());
        jmt.update(sql, parameter);
        //Persons persons=jtm.query(sql, new BeanPropertyRowMapper(Persons.class));
        return;

    }

    @Override
    public void updatePersons(Persons person) {
        String sql="UPDATE Persons set FirstName=:FirstName,LastName=:LastName, Age=:Age where Personid=:Personid";
        MapSqlParameterSource parameter=new MapSqlParameterSource();
        parameter.addValue("FirstName",person.getFirstName());
        parameter.addValue("LastName",person.getLastName());
        parameter.addValue("Age",person.getAge());
        parameter.addValue("Personid",person.getPersonid());
        jmt.update(sql,parameter);
    }

    @Override
    public void removePerson(int id) {
         String sql="DELETE from  Persons where Personid=:id";
         MapSqlParameterSource parameter=new MapSqlParameterSource();
         parameter.addValue("id", id);
        jmt.update(sql,parameter);
        return;
    }
    
}
//import org.springframework.beans.factory.annotation.Autowired;
//parameter.addValue(FirtName,person.getFirstName());
//parameter.addValue(FirtName,person.getFirstName());
        
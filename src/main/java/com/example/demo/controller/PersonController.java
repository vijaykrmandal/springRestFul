package com.example.demo.controller;

import java.util.List;
import com.example.demo.errorMessage.ErrorMessage;
import com.example.demo.model.Persons;
import com.example.demo.service.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.lang.NonNull;

@RestController
public class PersonController {
    @Autowired
    private PersonServiceImp service;

    @GetMapping("/persons")
    public ResponseEntity<?> getAllPersons(){
        List<Persons> persons=service.findAll();    
        if(persons!=null && !persons.isEmpty()){
            return new ResponseEntity< List<Persons>>(persons,HttpStatus.OK);
        }   
        else{
            return new ResponseEntity<ErrorMessage>(new  ErrorMessage("Resourse Not Found !!"),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<?> getAllPersonByID(@PathVariable ("id") String id){
        try {
            Persons persons=service.findById(Integer.parseInt(id));    
            return new ResponseEntity<Persons>(persons,HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<ErrorMessage>(new  ErrorMessage("Resourse Not Found !!"),HttpStatus.NOT_FOUND);
            }
    }

    @PostMapping("/persons")
    public ResponseEntity<?> addPerson(@RequestBody @NonNull Persons person){
        service.addPersons(person);
        if(person!=null){
            return new ResponseEntity<Persons>(person,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ErrorMessage>(new  ErrorMessage("Resourse Not Found !!"),HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> removePerson(@PathVariable("id") String id){
        service.removePerson(Integer.parseInt(id));
        if(id!=null){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<ErrorMessage>(new  ErrorMessage("Resourse Not Found !!"),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable("id") String id,@RequestBody @NonNull Persons person ){
        person.setPersonid(Integer.parseInt(id));
        service.updatePersons(person);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }

}

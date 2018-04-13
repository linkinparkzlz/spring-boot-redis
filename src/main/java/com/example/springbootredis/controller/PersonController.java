package com.example.springbootredis.controller;

import com.example.springbootredis.entity.Person;
import com.example.springbootredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @PostMapping("/save")
    public Person save(@RequestBody Person person) {


        personRepository.savePerson(person);

        return person;

    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable String id) {


        return personRepository.findPerson(id);
    }


}

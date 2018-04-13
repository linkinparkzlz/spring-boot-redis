package com.example.springbootredis.repository;

import com.example.springbootredis.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String, Person> repository = new HashMap<>();


    @Override
    public Person findPerson(String id) {


        return repository.get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        return repository.putIfAbsent(person.getId(), person) == null;
    }
}






























package com.example.springbootredis.repository;

import com.example.springbootredis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String, Person> repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;


//    @Override
//    public Person findPerson(String id) {
//
//
//        return repository.get(id);
//    }


    @Override
    public Person findPerson(String id) {


        return (Person) redisTemplate.opsForValue().get(id);
    }


//    @Override
//    public boolean savePerson(Person person) {
//        return repository.putIfAbsent(person.getId(), person) == null;
//    }


    @Override
    public boolean savePerson(Person person) {

        redisTemplate.opsForValue().set(person.getId(), person);

        return true;
    }

}






























package com.example.springbootredis.repository;

import com.example.springbootredis.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonRepository {


    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);

    boolean savePerson(Person person);


}











































































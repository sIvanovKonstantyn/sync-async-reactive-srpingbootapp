package com.example.demo.repositories;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAllByFirstName(String firstName);
}

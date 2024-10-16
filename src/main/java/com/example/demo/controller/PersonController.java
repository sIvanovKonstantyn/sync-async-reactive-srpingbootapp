package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping
    public void save(@RequestBody Person person) {
        longSaveProcess(person);
    }

    @SneakyThrows
    private void longSaveProcess(Person person) {
        Thread.sleep(5000);
        repository.save(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(repository.findAllByFirstName(firstName));
    }
}

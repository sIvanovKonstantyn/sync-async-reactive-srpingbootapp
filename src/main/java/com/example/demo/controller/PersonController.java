package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repositories.PersonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @Async
    @PostMapping
    public CompletableFuture<Long> save(@RequestBody Person person) {
        return CompletableFuture
                .supplyAsync(() -> longSaveProcess(person));
    }

    @SneakyThrows
    private Long longSaveProcess(Person person) {
        Thread.sleep(5000);
        return repository.save(person).getId();
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllByFirstName(@RequestParam String firstName) {
        return ResponseEntity.ok(repository.findAllByFirstName(firstName));
    }
}

package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/network")
public class SocialNetworkController {


    private final List<Person> people = new ArrayList<>();
    public SocialNetworkController() {
        people.add(new Person(1,"John"));
        people.add(new Person(2,"Mary"));
    }
    @GetMapping
    public List<Person> getPeople() {
        return people;
    }
    @GetMapping("/count")
    public int countPeople() {
        return people.size();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return people.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }


    @PostMapping
    public int createPerson(@RequestParam String name) {
        int id = 1 + people.size();
        people.add(new Person(id, name));
        return id;
    }
    @PostMapping(value = "/person", consumes="application/json")
    public ResponseEntity<String>
    createPerson(@RequestBody Person person) {
        people.add(person);
        return new ResponseEntity<>(
                "Person created successfully", HttpStatus.CREATED);
    }





    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable int id, @RequestParam String name) {
        Person person = getPerson(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(name);
        return new ResponseEntity<>(
                "Person updated successfully", HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        Person person = getPerson(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.GONE);
        }
        people.remove(person);
        return new ResponseEntity<>("Person removed", HttpStatus.OK);
    }





}




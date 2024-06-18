package com.ruquet.peopledb_web.web.controller;

import com.ruquet.peopledb_web.biz.model.Person;
import com.ruquet.peopledb_web.data.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonByID(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        }
        return ResponseEntity.notFound().build();
    }

}

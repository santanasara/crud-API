package com.example.basicAPI.api;

import com.example.basicAPI.model.Person;
import com.example.basicAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personRepository.save(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<Person> getPersonById(@PathVariable("id") UUID id){
        return personRepository.findById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personRepository.deleteById(id);
    }

}

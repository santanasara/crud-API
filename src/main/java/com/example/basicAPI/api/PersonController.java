package com.example.basicAPI.api;

import com.example.basicAPI.model.Person;
import com.example.basicAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "delete/{id}")
    public int deletePerson(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }

    @PutMapping(path = "update/{id}")
    public int updatePerson(@PathVariable("id") UUID id, @RequestBody Person person){
        return personService.updatePerson(id, person);
    }
}

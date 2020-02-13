package com.example.basicAPI.dao;

import com.example.basicAPI.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> selectedPerson = selectPersonById(id);
        if(selectedPerson.isEmpty()){
            return -1;
        }
        DB.remove(selectedPerson.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {

        if (!(selectPersonById(id)).toString().equals("{}")){
                selectPersonById(id).map(p -> {
                int indexOfPersonToUpdate = DB.indexOf(person);
                DB.set(indexOfPersonToUpdate, person);
                return 1;
            });
        }
        return -1;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }


}

package com.example.basicAPI.repository;

import com.example.basicAPI.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {

}

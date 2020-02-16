package com.example.basicAPI.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Person {

@Getter
@AllArgsConstructor
public class Person {
    @JsonProperty
    @Id
    private final UUID id;
    @JsonProperty
    private final String name;


}


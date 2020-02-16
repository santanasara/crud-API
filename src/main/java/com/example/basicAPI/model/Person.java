package com.example.basicAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Person {
    @Id
    @JsonProperty
    private final UUID id = UUID.randomUUID();
    @JsonProperty
    private final String name;

}


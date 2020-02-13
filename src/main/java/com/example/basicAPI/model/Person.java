package com.example.basicAPI.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Person {
    @JsonProperty
    private final UUID id;
    @JsonProperty
    private final String name;


}


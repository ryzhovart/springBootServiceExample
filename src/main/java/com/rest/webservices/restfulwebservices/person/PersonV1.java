package com.rest.webservices.restfulwebservices.person;

import lombok.ToString;

@ToString
public class PersonV1 {

    private String name;

    public PersonV1(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}

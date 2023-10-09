package com.rest.webservices.restfulwebservices.person;

import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("name surname");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        Name name = new Name("name", "secondName");
        return new PersonV2(name);

    }
}

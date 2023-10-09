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

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam(){
        return new PersonV1("name surname");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam(){
        Name name = new Name("name", "secondName");
        return new PersonV2(name);
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeaderParam(){
        return new PersonV1("name surname");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeaderParam(){
        Name name = new Name("name", "secondName");
        return new PersonV2(name);
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeaderParam(){
        return new PersonV1("name surname");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeaderParam(){
        Name name = new Name("name", "secondName");
        return new PersonV2(name);
    }

}

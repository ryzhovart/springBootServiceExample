package com.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private Long id;

    @Size(min=2, message = "name should have at least 2 chars")
    private String name;

    @Past(message = "this is not requires, but here we can specify, that date should be in past")
    private LocalDate birthDate;
}

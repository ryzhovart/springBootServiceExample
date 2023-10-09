package com.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("user_name")
    private String name;

    @Past(message = "this is not requires, but here we can specify, that date should be in past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}

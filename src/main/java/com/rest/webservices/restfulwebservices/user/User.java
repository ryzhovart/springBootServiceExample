package com.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity(name="user_details")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=2, message = "name should have at least 2 chars")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "this is not requires, but here we can specify, that date should be in past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}

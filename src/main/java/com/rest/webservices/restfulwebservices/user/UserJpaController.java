package com.rest.webservices.restfulwebservices.user;

import com.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {

    private final UserRepository repository;

    public UserJpaController(UserRepository repository) {

        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @PostMapping("/jpa/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/jpa/{id}").buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/user/{id}")
    public User retrieveUserById(@PathVariable Long id) {
        Optional<User> userOptional = repository.findById(id);
        return userOptional.orElseThrow(()->new UserNotFoundException("user not found id: " + id));
    }

    @DeleteMapping("/jpa/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
         repository.deleteById(id);
    }

}

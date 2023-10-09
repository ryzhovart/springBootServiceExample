package com.rest.webservices.restfulwebservices.user;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Long userLastId = 0L;

    static {
        users.add(new User(++userLastId, "user1", LocalDate.now().minusYears(30)));
        users.add(new User(++userLastId, "user2", LocalDate.now().minusYears(25)));
        users.add(new User(++userLastId, "user3", LocalDate.now().minusYears(33)));
    }

    public List<User> findAll() {
        return users;
    }

    public User create(User user) {
        user.setId(++userLastId);
        users.add(user);
        return user;
    }

    public User getById(Long id) {
        return users.stream().filter(u->u.getId().equals(id)).findAny().orElseThrow(()-> new UserNotFoundException("id:" + id));
    }

    public void deleteById(Long id) {
        users.removeIf(u->u.getId().equals(id));
    }
}

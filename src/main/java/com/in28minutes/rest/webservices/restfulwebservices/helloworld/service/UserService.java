package com.in28minutes.rest.webservices.restfulwebservices.helloworld.service;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class UserService {

    static List<User> users = new ArrayList<>();
    static Integer count = 0;

    static
    {
        users.add(new User(++count,"Nitish", LocalDate.now().minusYears(30)));
        users.add(new User(++count,"Ambika", LocalDate.now().minusYears(25)));
        users.add(new User(++count,"Ravi", LocalDate.now().minusYears(27)));
    }


    public User save(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }

    public List<User> findAll() {

        return users;
    }

    public User getUserById(Integer id) {

        User user = null;
        for (User tempUser: users) {
            if(tempUser.getId() == id)
            {
                user = tempUser;
            }
        }
        return user;
    }
}

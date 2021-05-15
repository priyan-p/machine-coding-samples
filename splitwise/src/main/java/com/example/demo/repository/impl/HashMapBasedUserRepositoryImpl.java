package com.example.demo.repository.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.example.demo.model.User;

import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class HashMapBasedUserRepositoryImpl {

    private static final Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("user-1", new User("user-1", "username1", "user1@email.com"));
        USERS.put("user-2", new User("user-2", "username2", "user2@email.com"));
        USERS.put("user-3", new User("user-3", "username3", "user3@email.com"));
    }

    public User addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        USERS.put(user.getId(), user);
        return user;
    }

}

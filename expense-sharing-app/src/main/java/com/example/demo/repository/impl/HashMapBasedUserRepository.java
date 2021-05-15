package com.example.demo.repository.impl;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapBasedUserRepository implements UserRepository {

    private static final Map<String, User> USERS = new HashMap<>();

    static {
        USERS.put("1", new User("1", "user1", "user1@email.com", "9876543210"));
        USERS.put("2", new User("2", "user2", "user2@email.com", "9876543210"));
        USERS.put("3", new User("3", "user3", "user3@email.com", "9876543210"));
        USERS.put("4", new User("4", "user4", "user4@email.com", "9876543210"));
        USERS.put("5", new User("5", "user5", "user5@email.com", "9876543210"));
    }


    @Override
    public User getUser(String userId) {
        if (!USERS.containsKey(userId))
            throw new UserNotFoundException();
        return USERS.get(userId);
    }
}

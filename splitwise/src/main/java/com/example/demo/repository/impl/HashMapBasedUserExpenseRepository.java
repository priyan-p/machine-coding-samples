package com.example.demo.repository.impl;

import com.example.demo.model.UserExpense;
import com.example.demo.repository.UserExpenseRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class HashMapBasedUserExpenseRepository implements UserExpenseRepository {

    private static final Map<String, UserExpense> USER_EXPENSE_MAP = new HashMap<>();

    static {
        USER_EXPENSE_MAP.put("user-1", new UserExpense("user-1",new ArrayList<>(), new ArrayList<>()));
        USER_EXPENSE_MAP.put("user-2", new UserExpense("user-2",new ArrayList<>(), new ArrayList<>()));
        USER_EXPENSE_MAP.put("user-3", new UserExpense("user-3",new ArrayList<>(), new ArrayList<>()));
    }

    @Override
    public void addUserExpense(UserExpense userExpense) {
        USER_EXPENSE_MAP.put(userExpense.getUserId(), userExpense);
    }

    @Override
    public UserExpense getUserExpense(String userId) {
        return USER_EXPENSE_MAP.get(userId);
    }

}

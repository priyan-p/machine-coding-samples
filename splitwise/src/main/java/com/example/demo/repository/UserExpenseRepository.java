package com.example.demo.repository;

import com.example.demo.model.UserExpense;

public interface UserExpenseRepository {

    void addUserExpense(UserExpense userExpense);

    UserExpense getUserExpense(String userId);

}

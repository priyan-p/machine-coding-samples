package com.example.demo.repository.impl;

import com.example.demo.model.Expense;
import com.example.demo.model.ExpenseMetadata;
import com.example.demo.model.SplitUserAmount;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class HashMapBasedExpenseRepository implements ExpenseRepository {

    private static final List<Expense> EXPENSES = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    public void logExpense(String userPaid, List<SplitUserAmount> splitUserAmounts, ExpenseMetadata expenseMetadata) {
        Expense expense = new Expense();
        expense.setId(new Random().nextInt(999999999 - 1) + 1);
        expense.setPaidBy(userRepository.getUser(userPaid));
        expense.setExpenseMetadata(expenseMetadata);
        expense.setSplitUserAmounts(splitUserAmounts);
        EXPENSES.add(expense);
    }


}

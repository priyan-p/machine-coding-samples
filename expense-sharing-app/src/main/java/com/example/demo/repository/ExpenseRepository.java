package com.example.demo.repository;

import com.example.demo.model.ExpenseMetadata;
import com.example.demo.model.SplitUserAmount;

import java.util.List;

public interface ExpenseRepository {

    void logExpense(String userPaid, List<SplitUserAmount> splitUserAmounts, ExpenseMetadata expenseMetadata);

}

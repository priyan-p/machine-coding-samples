package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Expense {

    private int id;

    private User paidBy;

    private List<SplitUserAmount> splitUserAmounts;

    private ExpenseMetadata expenseMetadata;

}

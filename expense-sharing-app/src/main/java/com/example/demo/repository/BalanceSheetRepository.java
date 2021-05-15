package com.example.demo.repository;

import com.example.demo.model.SplitUserAmount;

import java.util.Map;
import java.util.Set;

public interface BalanceSheetRepository {

    void addExpense(String userPaid, String userToPayback, double amount);

    Set<SplitUserAmount> getBalaceSheet(String userId);

    Map<String, Set<SplitUserAmount>> getAllBalaceSheets();

}

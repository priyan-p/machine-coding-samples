package com.example.demo.service;

import com.example.demo.factory.SplitFactory;
import com.example.demo.model.ExpenseMetadata;
import com.example.demo.model.Split;
import com.example.demo.model.SplitUserAmount;
import com.example.demo.repository.BalanceSheetRepository;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.type.SplitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ExpenseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BalanceSheetRepository balanceSheetRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    public void addExpense(String userId, Map<String, String> usersToSplit, SplitType splitType, double amount, ExpenseMetadata expenseMetadata) {
        Split split = SplitFactory.getInstance(splitType);
        List<SplitUserAmount> splitUserAmounts = split.splitAmounts(usersToSplit, amount);
        splitUserAmounts.stream()
                .forEach(s -> balanceSheetRepository.addExpense(userId, s.getUserId(),
                        s.getAmount()));
        expenseRepository.logExpense(userId, splitUserAmounts, expenseMetadata);
    }

    public Set<SplitUserAmount> getBalanceSheet(String userId) {
        return balanceSheetRepository.getBalaceSheet(userId);
    }

    public Map<String, Set<SplitUserAmount>> getAllBalanceSheets() {
        return balanceSheetRepository.getAllBalaceSheets();
    }

}

package com.example.demo.repository.impl;

import com.example.demo.model.SplitUserAmount;
import com.example.demo.repository.BalanceSheetRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class HashMapBasedBalanceSheetRepository implements BalanceSheetRepository {

    private static final Map<String, Set<SplitUserAmount>> BALANCE_SHEET = new HashMap<>();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addExpense(String userPaid, String userToPayback, double amount) {
        if (!BALANCE_SHEET.containsKey(userPaid)) {
            BALANCE_SHEET.put(userPaid, new HashSet<>());
        }

        SplitUserAmount splitUserAmount = BALANCE_SHEET.get(userPaid).stream()
                .filter(s -> s.getUserId().equals(userToPayback))
                .findFirst()
                .map(s -> {
                    s.setAmount(s.getAmount() + amount);
                    return s;
                })
                .orElse(new SplitUserAmount(userToPayback, amount));

        BALANCE_SHEET.get(userPaid).add(splitUserAmount);

    }

    @Override
    public Set<SplitUserAmount> getBalaceSheet(String userId) {
        return BALANCE_SHEET.get(userId);
    }

    @Override
    public Map<String, Set<SplitUserAmount>> getAllBalaceSheets() {
        return BALANCE_SHEET;
    }

}

package com.example.demo.service;

import com.example.demo.model.UserAmount;
import com.example.demo.model.UserExpense;
import com.example.demo.repository.UserExpenseRepository;
import com.example.demo.types.SharingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private UserExpenseRepository userExpenseRepository;

    public void addExpense(String userId, double amount, List<String> sharedUsers, SharingType sharingType) {

        if (SharingType.EQUAL == sharingType) {

            final double sharedAmount = amount / (sharedUsers.size() + 1);
            final UserExpense userExpense = userExpenseRepository.getUserExpense(userId);

            userExpense.getExpectedAmountFromUsers().addAll(
                    sharedUsers.stream()
                            .map(u -> new UserAmount(u, sharedAmount))
                            .collect(Collectors.toList())
            );

            sharedUsers.forEach(sharedUser ->
                    userExpenseRepository.getUserExpense(sharedUser)
                            .getPayBackAmountToUsers().add(new UserAmount(userId, sharedAmount))
            );
        } else {
            throw new RuntimeException("Invalid sharing type");
        }

    }

    public UserExpense getUserExpenseInfo(String userId) {
        return userExpenseRepository.getUserExpense(userId);
    }

}

package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserExpense;
import com.example.demo.model.UserExpenseInfo;
import com.example.demo.service.ExpenseService;
import com.example.demo.types.SharingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseManagingController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public UserExpense getUserExpense(@RequestParam String userId) {
        return expenseService.getUserExpenseInfo(userId);
    }

    @PostMapping("/{userId}")
    public void addExpense(@PathVariable String userId, @RequestBody UserExpenseInfo userExpenseInfo) {
        expenseService.addExpense(userId, userExpenseInfo.getAmount(), userExpenseInfo.getSharedUsers(), SharingType.EQUAL);
    }

}

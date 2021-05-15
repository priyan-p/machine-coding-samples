package com.example.demo;

import com.example.demo.service.ExpenseService;
import com.example.demo.type.SplitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private ExpenseService expenseService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Map<String, String> expenseMap = new HashMap<>();
        expenseMap.put("2", "30");
        expenseMap.put("4", "40");
        expenseService.addExpense("1", expenseMap, SplitType.EXACT, 70.0, null);
        expenseMap.put("1", "40");
        expenseService.addExpense("3", expenseMap, SplitType.EQUAL, 400.0, null);

        expenseMap.put("1", "");
        expenseMap.put("3", "");
        expenseMap.put("4", "");
        expenseService.addExpense("2", expenseMap, SplitType.EQUAL, 1000.0, null);

        System.out.println(expenseService.getAllBalanceSheets());

    }
}

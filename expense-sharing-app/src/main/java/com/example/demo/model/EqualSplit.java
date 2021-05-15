package com.example.demo.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EqualSplit implements Split {

    @Override
    public List<SplitUserAmount> splitAmounts(Map<String, String> usersToSplit, double amount) {
        double splitAmount = amount / usersToSplit.size();
        return usersToSplit.entrySet()
                .stream()
                .map(e -> new SplitUserAmount(e.getKey(), splitAmount))
                .collect(Collectors.toList());
    }
}

package com.example.demo.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExactSplit implements Split {

    @Override
    public List<SplitUserAmount> splitAmounts(Map<String, String> usersToSplit, double amount) {

        if (usersToSplit.values()
                .stream()
                .mapToDouble(a -> Double.parseDouble(a))
                .sum() != amount) {
            throw new RuntimeException("Invalid Request");
        }

        return usersToSplit.entrySet()
                .stream()
                .map(e -> new SplitUserAmount(e.getKey(), Double.parseDouble(e.getValue())))
                .collect(Collectors.toList());

    }
}

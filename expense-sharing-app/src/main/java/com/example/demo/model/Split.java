package com.example.demo.model;

import java.util.List;
import java.util.Map;

public interface Split {

    List<SplitUserAmount> splitAmounts(Map<String, String> usersToSplit, double amount);

}

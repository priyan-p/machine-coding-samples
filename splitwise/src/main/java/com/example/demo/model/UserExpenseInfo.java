package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class UserExpenseInfo {

    private List<String> sharedUsers;

    private Double amount;

}

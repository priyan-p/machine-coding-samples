package com.example.demo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserExpense {

    private String userId;

    private List<UserAmount> payBackAmountToUsers;

    private List<UserAmount> expectedAmountFromUsers;

}

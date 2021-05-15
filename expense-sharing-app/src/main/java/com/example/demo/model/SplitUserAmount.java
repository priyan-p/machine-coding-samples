package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Objects;

@Data
@NoArgsConstructor
public class SplitUserAmount {

    public SplitUserAmount(String userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    private String userId;

    private double amount;

    private String displayAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SplitUserAmount that = (SplitUserAmount) o;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public String getDisplayAmount() {
        return new DecimalFormat("0.00").format(amount);
    }
}

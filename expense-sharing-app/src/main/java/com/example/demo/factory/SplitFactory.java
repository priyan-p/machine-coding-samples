package com.example.demo.factory;

import com.example.demo.model.EqualSplit;
import com.example.demo.model.ExactSplit;
import com.example.demo.model.Split;
import com.example.demo.type.SplitType;

public class SplitFactory {

    public static Split getInstance(SplitType splitType) {
        if (splitType == SplitType.EQUAL) {
            return new EqualSplit();
        } else if (splitType == SplitType.EXACT) {
            return new ExactSplit();
        } else {
            throw new RuntimeException("Invalid split type");
        }
    }

}

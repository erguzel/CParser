package com.prs.abstraction.model;

import com.prs.abstraction.ConstraintTypes;

public class Flag {

    private String MeaningfulName;

    private ConstraintTypes consType;

    public Flag(String meaningfulName, ConstraintTypes consType) {
        MeaningfulName = meaningfulName;
        this.consType = consType;
    }

    public String getMeaningfulName() {
        return MeaningfulName;
    }

    public void setMeaningfulName(String meaningfulName) {
        MeaningfulName = meaningfulName;
    }

    public ConstraintTypes getConsType() {
        return consType;
    }

    public void setConsType(ConstraintTypes consType) {
        this.consType = consType;
    }
}

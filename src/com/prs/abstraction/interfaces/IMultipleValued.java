package com.prs.abstraction.interfaces;

import java.util.List;

public interface IMultipleValued {

    void addValue(String value);
    void addValueRange(String[] valueRange);
    List<String > getValues();

}

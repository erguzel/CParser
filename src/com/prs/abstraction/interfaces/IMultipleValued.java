package com.prs.abstraction.interfaces;

import java.util.List;

public interface IMultipleValued {

    void addValue(String value) throws Exception;

    void addValueRange(String[] valueRange) throws Exception;

    List<? extends Object > getValues();

}

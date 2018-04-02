package com.prs.abstraction.interfaces;

import java.util.List;

public interface IMultipleValued {

    /**
     * Adds a value to a multiple valued object
     * @param value
     * @throws Exception
     */
    void addValue(String value) throws Exception;

    /**
     * Adds value range to a multiple valued object
     * @param valueRange
     * @throws Exception NumberFormatException
     */
    void addValueRange(String[] valueRange) throws Exception;

    List<? extends Object > getValues();

}

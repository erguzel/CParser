package com.prs.abstraction.interfaces;

public interface IValued {
    /**
     * Sets the value of a defined argument
     * @param value
     * @throws Exception
     */
    void setValue(Object value) throws Exception;

    /**
     * Gets the value of a defined argument
     * @return
     */
    Object  getValue();


}

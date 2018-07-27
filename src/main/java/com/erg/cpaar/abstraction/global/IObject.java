package com.erg.cpaar.abstraction.global;

public interface IObject {

    Class<?> getDataType();
    public void setDataType(Class<?> dtype);
    Object getValue();
    public void setValue(Object o);

}

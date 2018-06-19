package com.erg.cpaar.data;

import com.erg.abst.cpaar.data.raw.INumberlist;

public class NumberList implements INumberlist{

    private Class<?> _dataType;

    public NumberList(Class<?> dataType) {
        _dataType = dataType;
    }

    @Override
    public Class<?> getDataType() {
        return _dataType;
    }

    @Override
    public void setDataType(Class<?> type) {
        _dataType = type;
    }
}

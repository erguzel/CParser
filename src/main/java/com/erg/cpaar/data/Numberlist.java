package com.erg.cpaar.data;

import com.erg.abst.cpaar.prepare.INumberlist;

public class Numberlist implements INumberlist{

    private Class<?> _dataType;

    public Numberlist(Class<?> dataType) {
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

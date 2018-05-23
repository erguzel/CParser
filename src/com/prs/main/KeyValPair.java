package com.prs.main;

import abstraction.cpar.enumic.ConstraintTypes;
import abstraction.cpar.interfaces.DataTypeParser;
import abstraction.cpar.interfaces.IKeyValPair;

public class KeyValPair extends DataTypeParser implements IKeyValPair {

    private String _expression;
    private String _valueSeparator;
    private Class<? extends Object> _dataType;
    private ConstraintTypes _consTypee;
    private String _meaningfulName;

    private Object _value;

    public KeyValPair(String _expression, String _valueSeparator, Class<? extends Object> _dataType, ConstraintTypes _consTypee, String _meaningfulName) {
        this._expression = _expression;
        this._valueSeparator = _valueSeparator;
        this._dataType = _dataType;
        this._consTypee = _consTypee;
        this._meaningfulName = _meaningfulName;
    }

    @Override
    public String get_valueSeparator() {
        return _valueSeparator;
    }

    @Override
    public String get_expression() {
        return _expression;
    }

    @Override
    public Class<? extends Object> get_dataType() {
        return _dataType;
    }

    @Override
    public ConstraintTypes getcType() {
        return _consTypee;
    }

    @Override
    public String get_meaningfulName() {
        return _meaningfulName;
    }


    @Override
    public void setValue(Object value) throws Exception {

        ParseDataType(value, _dataType);

        _value = value;
    }

    @Override
    public Object getValue() {
        return _value;
    }
}

package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.IKeyValPair;

public class KeyValPair implements IKeyValPair {

    private String _expression;
    private String _valueSeparator;
    private Class _dataType;
    private ConstraintTypes _consTypee;
    private String _meaningfulName;

    public KeyValPair(String _expression, String _valueSeparator, Class _dataType, ConstraintTypes _consTypee, String _meaningfulName) {
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
    public Class get_dataType() {
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
}

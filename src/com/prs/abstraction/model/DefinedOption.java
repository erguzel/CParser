package com.prs.abstraction.model;

import com.prs.abstraction.ConstraintTypes;

public class DefinedOption {

    private boolean _isMultipleValuesAccepted;
    private String _valueSeparator;

    private String _expression;
    private Class _dataType;
    private ConstraintTypes cType;
    private String _meaningfulName;

    public DefinedOption(boolean _isMultipleValuesAccepted, String _valueSeparator, String _expression, Class _dataType, ConstraintTypes cType, String _meaningfulName) {
        this._isMultipleValuesAccepted = _isMultipleValuesAccepted;
        this._valueSeparator = _valueSeparator;
        this._expression = _expression;
        this._dataType = _dataType;
        this.cType = cType;
        this._meaningfulName = _meaningfulName;
    }

    public boolean is_isMultipleValuesAccepted() {
        return _isMultipleValuesAccepted;
    }

    public String get_valueSeparator() {
        return _valueSeparator;
    }

    public String get_expression() {
        return _expression;
    }

    public Class get_dataType() {
        return _dataType;
    }

    public ConstraintTypes getcType() {
        return cType;
    }

    public String get_meaningfulName() {
        return _meaningfulName;
    }
}

package com.erg.cpaar.data;

import com.erg.abst.cpaar.IOption;

public class Option implements IOption {

    private boolean _isMultipleValued;
    private Class<?> _dataType;

    public void set_isMultipleValued(boolean _isMultipleValued) {
        this._isMultipleValued = _isMultipleValued;
    }

    public void set_dataType(Class<?> _dataType) {
        this._dataType = _dataType;
    }

    public void set_isMandatory(boolean _isMandatory) {
        this._isMandatory = _isMandatory;
    }

    public void set_expression(String _expression) {
        this._expression = _expression;
    }

    private boolean _isMandatory;
    private String _expression;

    public Option(String regex, Class<?> dataType, boolean isMandatory) {

        _isMandatory = isMandatory;
        _dataType = dataType;
        _expression = regex;
    }

    @Override
    public Class<?> getDataType() {
        return _dataType;
    }

    @Override
    public String getExpression() {
        return  _expression;
    }

    @Override
    public boolean isMultipleValued() {
        return _isMultipleValued;
    }

    @Override
    public boolean isMandatory() {
        return  _isMandatory;
    }
}

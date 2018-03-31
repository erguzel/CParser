package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.DataTypeParser;
import com.prs.abstraction.interfaces.IOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class Option extends DataTypeParser implements IOption {

    private boolean _isMultipleValuesAccepted;
    private String _valueSeparator;

    private String _expression;
    private Class<? extends Object> _dataType;
    private ConstraintTypes cType;
    private String _meaningfulName;

    private List<String> _RawValues = new ArrayList<>();
    private List<Object> _values = new LinkedList<Object>();

    public Option(boolean _isMultipleValuesAccepted, String _valueSeparator, String _expression, Class<? extends Object> _dataType, ConstraintTypes cType, String _meaningfulName) {
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

    public Class<? extends Object> get_dataType() {
        return _dataType;
    }

    public ConstraintTypes getcType() {
        return cType;
    }

    public String get_meaningfulName() {
        return _meaningfulName;
    }

    @Override
    public void addValue(String value) throws Exception {

        _RawValues.add(value);

        ParseDataType(value,_values,_dataType);
    }

    @Override
    public void addValueRange(String[] valueRange) throws Exception {

        for(String val : valueRange){

            _RawValues.add(val);

            addValue(val);

        }
    }

    @Override
    public List<Object> getValues() {

        return _values;
    }


}

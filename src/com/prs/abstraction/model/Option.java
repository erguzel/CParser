package com.prs.abstraction.model;



import com.prs.abstraction.ConstraintTypes;
import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IOptioned;


public class Option implements IOptioned {
    private boolean _isMultipleValuesAccepted;
    private String _valueSeparator;

    private String _expression;
    private Class _dataType;
    private ConstraintTypes _cType;

    private String _meaningfulName;

    public Option(String _expression, Class _dataType, ConstraintTypes _cType) {
        this._expression = _expression;
        this._dataType = _dataType;
        this._cType = _cType;
    }

    @Override
    public IOptioned multipleValues(boolean choice) {
        _isMultipleValuesAccepted = choice;
        return this;
    }

    @Override
    public IOptioned valueSeparator(String separator) {
        _valueSeparator = separator;
        return this;
    }


    @Override
    public ICmdParser submit(String giveMeaningfulName) {
        _meaningfulName = giveMeaningfulName;

        CmdParser.Utility.addOption(new DefinedOption(_isMultipleValuesAccepted,
                _valueSeparator,_expression,_dataType, _cType,_meaningfulName));
        return new CmdParser();
    }
}

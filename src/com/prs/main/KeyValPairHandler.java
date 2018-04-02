package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IKeyValuePaired;

import java.util.stream.Collectors;

public class KeyValPairHandler implements IKeyValuePaired {
    private String _expression;
    private String _valueSeparator;
    private Class<? extends Object> _dataType;
    private ConstraintTypes _consTypee;
    private String _meaningfulName;

    public KeyValPairHandler(String _expression, String _valueSeparator, Class<? extends Object> _dataType, ConstraintTypes _consTypee) {
        this._expression = _expression;
        this._valueSeparator = _valueSeparator;
        this._dataType = _dataType;
        this._consTypee = _consTypee;
    }

    @Override
    public ICmdParser submit(String giveMeaningfulName) throws Exception {

        _meaningfulName = giveMeaningfulName;

        if(CParser.Utility.getKvPairs().stream().map(a->a.get_expression()).collect(Collectors.toList()).contains(_expression)){
            throw new Exception("Error:..." + _expression + " key-val pair already defined");
        }

        CParser.Utility.addKvP(new KeyValPair(_expression,_valueSeparator,_dataType,_consTypee,_meaningfulName));

        return new CParser();
    }
}

package com.prs.main;

import abstraction.cpar.interfaces.IFlag;
import abstraction.cpar.interfaces.IValued;

class Flag implements IFlag {


    private String _expression;

    private String _meaningfulName;

    private boolean _value = false;

    public Flag(String _expression, String _meaningfulName) {

        this._expression = _expression;

        this._meaningfulName = _meaningfulName;
    }

    public String get_expression() {

        return _expression;
    }

    public String get_meaningfulName() {

        return _meaningfulName;
    }

    @Override
    public void setValue(Object value) throws Exception {

        _value = (Boolean) value;
    }

    @Override
    public Object getValue() {

        return _value;
    }
}

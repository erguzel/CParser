package com.prs.main;

public class DefinedFlag {


    private String _expression;

    private String _meaningfulName;

    public DefinedFlag(String _expression, String _meaningfulName) {
        this._expression = _expression;
        this._meaningfulName = _meaningfulName;
    }

    public String get_expression() {
        return _expression;
    }

    public String get_meaningfulName() {
        return _meaningfulName;
    }

}

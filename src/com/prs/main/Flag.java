package com.prs.main;

import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IFlagged;

public class Flag implements IFlagged{

    private String _expression;
    private String _meaningfulName;

    public Flag(String expression) {
        this._expression = expression;
    }

    @Override
    public ICmdParser submit(String giveMeaningfulName) {
        _meaningfulName = giveMeaningfulName;

        CParser.Utility.addFlag(new DefinedFlag("-".concat(_expression),_meaningfulName));

        return new CParser();

    }
}

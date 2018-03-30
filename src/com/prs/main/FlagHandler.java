package com.prs.main;

import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IFlagged;

class FlagHandler implements IFlagged{

    private String _expression;
    private String _meaningfulName;

    public FlagHandler(String expression) {
        this._expression = expression;
    }

    @Override
    public ICmdParser submit(String giveMeaningfulName) {
        _meaningfulName = giveMeaningfulName;

        CParser.Utility.addFlag(new Flag("-".concat(_expression),_meaningfulName));

        return new CParser();

    }
}

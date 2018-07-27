package com.erg.cpaar.data;

import com.erg.cpaar.abstraction.data.raw.IFlag;

public class Flag implements IFlag{
    private String  _name;
    private String _regex;

    private String regex;

    public Flag(String regex) {

        this._regex = regex;

    }


    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public String getRegex() {
        return _regex;
    }

    @Override
    public void setRegex(String expression) {
        _regex = expression;
    }
}

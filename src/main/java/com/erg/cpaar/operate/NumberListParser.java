package com.erg.cpaar.operate;

import com.erg.cpaar.abstraction.data.raw.INumberlist;
import com.erg.cpaar.abstraction.global.IExecutable;
import com.erg.cpaar.data.Inputs;
import com.erg.cpaar.data.Outputs;

public class NumberListParser implements IExecutable {

    private INumberlist _numlist;
    public NumberListParser(INumberlist numlist) throws Exception {

        _numlist = numlist;
        execute();
    }

    @Override
    public void execute() throws Exception {

        System.out.println("Parse unoptioned numbers: TODO");

    }
}

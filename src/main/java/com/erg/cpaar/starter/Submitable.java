package com.erg.cpaar.starter;

import com.erg.abst.cpaar.IOption;
import com.erg.abst.cpaar.ISubmitable;
import com.erg.abst.cpaar.ISubmitted;
import com.erg.cpaar.data.Arguments;

public class Submitable implements ISubmitable {

    private IOption _option;

    public Submitable(IOption option) {
        _option = option;

    }

    @Override
    public ISubmitted submit(String meaningfulName) {

        Arguments.Options.put(meaningfulName,_option);
        return new Submitted();

    }

}

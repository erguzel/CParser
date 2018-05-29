package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.data.raw.IOption;
import com.erg.abst.cpaar.prepare.ISubmitable;
import com.erg.abst.cpaar.prepare.ISubmitted;
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

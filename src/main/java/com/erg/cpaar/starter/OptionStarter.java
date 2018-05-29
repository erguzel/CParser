package com.erg.cpaar.starter;

import com.erg.abst.cpaar.IOption;
import com.erg.abst.cpaar.IOptionStarter;
import com.erg.abst.cpaar.ISubmitable;

public class OptionStarter implements IOptionStarter {

    private IOption _option;

    public OptionStarter(IOption option){
        _option = option;
    }

    @Override
    public ISubmitable isMultipleValued(boolean isMultipleValueAccepted) {
        _option.set_isMultipleValued(isMultipleValueAccepted);
        return new Submitable(_option);
    }
}

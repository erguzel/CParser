package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.data.raw.IOption;
import com.erg.abst.cpaar.prepare.IOptionStarter;
import com.erg.abst.cpaar.prepare.ISubmitable;

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

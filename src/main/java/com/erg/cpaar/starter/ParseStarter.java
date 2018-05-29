package com.erg.cpaar.starter;

import com.erg.abst.cpaar.IParseStarter;
import com.erg.cpaar.data.Option;

public class ParseStarter implements IParseStarter {

    @Override
    public OptionStarter addOption(String regex, Class<?> dataType, boolean isMandatory) {

        return new OptionStarter(new Option(regex,dataType,isMandatory));
    }
}

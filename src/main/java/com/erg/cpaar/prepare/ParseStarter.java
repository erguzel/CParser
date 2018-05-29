package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.prepare.IParseStarter;
import com.erg.cpaar.data.raw.Option;

public class ParseStarter implements IParseStarter {

    @Override
    public OptionStarter addOption(String regex, Class<?> dataType, boolean isMandatory) {

        return new OptionStarter(new Option(regex,dataType,isMandatory));
    }
}

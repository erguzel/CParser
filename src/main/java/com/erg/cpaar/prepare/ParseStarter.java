package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.prepare.IAdded;
import com.erg.abst.cpaar.prepare.IArgument;
import com.erg.abst.cpaar.prepare.IParserStarter;
import com.erg.cpaar.data.Argument;
import com.erg.cpaar.data.Flag;
import com.erg.cpaar.data.Option;

public class ParseStarter implements IParserStarter{

    private IArgument _arg;

    @Override
    public IAdded add(String regex, Class<?> dataType, boolean isMandatory) {
        return new Added(new Argument(regex,dataType,isMandatory));
    }

    @Override
    public IAdded addOption(String regex, Class<?> dataType, boolean isMandatory) {
        return new Added(new Option(regex,dataType,isMandatory));
    }

    @Override
    public IAdded addFlag(String regex) {

        return new Added(new Flag(regex));
    }

}

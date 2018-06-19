package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.BareArgumentTypes;
import com.erg.abst.cpaar.prepare.IAdded;
import com.erg.abst.cpaar.data.raw.IArgument;
import com.erg.abst.cpaar.prepare.IParserStarter;
import com.erg.abst.enm.ExtensionTypes;
import com.erg.cpaar.data.FileList;
import com.erg.cpaar.data.Flag;
import com.erg.cpaar.data.NumberList;
import com.erg.cpaar.data.Option;

import static com.erg.abst.cpaar.BareArgumentTypes.file;

public class ParseStarter implements IParserStarter{

    private IArgument _arg;

    @Override
    public IAdded add(Class<?> aClass, BareArgumentTypes bareArgumentTypes) {
        switch (bareArgumentTypes){
            case number:
                return new Added(new NumberList(aClass));
            case file:
                return new Added(new FileList(ExtensionTypes.CSV));
                default:
                    return null;
        }
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

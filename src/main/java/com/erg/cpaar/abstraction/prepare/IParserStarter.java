package com.erg.cpaar.abstraction.prepare;

import com.erg.cpaar.abstraction.BareArgumentTypes;

public interface IParserStarter {

    public IAdded add(Class<?> dataType, BareArgumentTypes argType);
    public IAdded addOption(String regex, Class<?> dataType, boolean isMandatory);
    public IAdded addFlag(String regex);
}

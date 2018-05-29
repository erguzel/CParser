package com.erg.cpaar.starter;

import com.erg.abst.cpaar.IOptionStarter;
import com.erg.abst.cpaar.ISubmitted;
import com.erg.cpaar.data.Arguments;
import com.erg.cpaar.data.Option;

public class Submitted implements ISubmitted {
    @Override
    public void parse(String[] args) {

        //parse options

        Arguments.Options.forEach((a,b)-> System.out.println(a + ": " + b.getExpression() + "--" + b.getDataType().getSimpleName() + "--" + "ismandatory:" + b.isMandatory() + " isMulti: " + b.isMultipleValued() ));

    }

    @Override
    public IOptionStarter addOption(String regex, Class<?> dataType, boolean isMandatory) {
        return new OptionStarter(new Option(regex,dataType,isMandatory));
    }
}

package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.data.raw.IOption;
import com.erg.abst.cpaar.prepare.IOptionStarter;
import com.erg.abst.cpaar.prepare.ISubmitted;
import com.erg.cpaar.data.Arguments;
import com.erg.cpaar.data.raw.Option;
import com.erg.cpaar.operate.OptionParser;

import java.util.Map;

public class Submitted implements ISubmitted {
    @Override
    public void parse(String[] args) {

        for(String s : args){

            Arguments._args.add(s);
        }


        Arguments.Options.forEach((a, b) -> {
            try {
                new OptionParser(a,b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public IOptionStarter addOption(String regex, Class<?> dataType, boolean isMandatory) {
        return new OptionStarter(new Option(regex,dataType,isMandatory));
    }
}

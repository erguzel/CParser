package com.erg.cpaar.operate;

import com.erg.abst.cpaar.prepare.INumberlist;
import com.erg.abst.global.IExecutable;
import com.erg.cpaar.data.Inputs;
import com.erg.cpaar.data.Outputs;
import com.erg.util.datatype.TypeParser;
import java.util.LinkedHashSet;

public class NumberParser implements IExecutable {

    private INumberlist _numlist;
    public NumberParser(INumberlist numlist) throws Exception {

        _numlist = numlist;
        execute();
    }

    @Override
    public void execute() throws Exception {

         Inputs._args.stream()
         .forEach(a -> {
             try {
                 Outputs.numbers.add(TypeParser.ParseDataType(a.getClass(), a));
             } catch (Exception e) {
                 e.printStackTrace();
             }
         });

    }
}

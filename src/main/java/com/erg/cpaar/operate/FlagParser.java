package com.erg.cpaar.operate;

import com.erg.abst.cpaar.prepare.IFlag;
import com.erg.abst.global.IExecutable;
import com.erg.cpaar.data.Inputs;
import com.erg.cpaar.data.Outputs;

import java.util.ArrayList;
import java.util.List;

public class FlagParser implements IExecutable {

    private IFlag _flag ;

    public FlagParser(IFlag flag) {

        _flag = flag;
        execute();
    }

    @Override
    public void execute() {

        List<?> values = new ArrayList<Object>();

       if(Inputs._args.contains(_flag.getRegex().trim())){

           Outputs.flags.put(_flag.getName(),true);

       }
       else{
           Outputs.flags.put(_flag.getName(),false);
       }

    }
}

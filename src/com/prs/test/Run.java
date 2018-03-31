package com.prs.test;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.IFlag;
import com.prs.abstraction.interfaces.IKeyValPair;
import com.prs.abstraction.interfaces.IOption;
import com.prs.main.CParser;

import java.lang.reflect.Method;
import java.util.List;


public class Run {

    public static void main(String []args) throws Exception {

        CParser cm = new CParser();
        cm.AddOption("np",String.class,ConstraintTypes.Optional)
                .submit("np param")
                .AddOption("nt",float.class,ConstraintTypes.Optional)
                .submit("nt param")
                .AddFlag("fl")
                .submit("flag1")
                .AddKeyValuePair("std","=",String.class,ConstraintTypes.Optional)
                .submit("KeyValuPair")
                .parse(args);

        List<IOption> ide = CParser.Utility.getOptions();

        List<IFlag> fld = CParser.Utility.getFlags();

        List<IKeyValPair> kp = CParser.Utility.getKvPairs();

        for(IOption iop : CParser.Utility.getOptions()){

            iop.getValues().forEach(a->System.out.println(iop.get_meaningfulName()+ ": " + a.toString()));
        }

        for(IKeyValPair kvp : kp){

            System.out.println(kvp.get_meaningfulName()+": " + kvp.getValue());
        }


    }


}

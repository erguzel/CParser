package com.prs.test;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.IFlag;
import com.prs.abstraction.interfaces.IOption;
import com.prs.main.CParser;

import java.util.List;


public class Run {

    public static void main(String []args) throws Exception {

        CParser cm = new CParser();
        cm.AddOption("np",String.class,ConstraintTypes.Optional)
                .multipleValues(" ")
                .submit("param1")
                .AddOption("nt",Integer.class,ConstraintTypes.Mandatory)
                .multipleValues(",")
                .submit("param2")
                .AddFlag("fl")
                .submit("flag1")
                .AddKeyValuePair("std","=",Integer.class,ConstraintTypes.Mandatory)
                .submit("KeyValuPair")
                .parse(args);

        List<IOption> ide = CParser.Utility.getOptions();

        List<IFlag> fld = CParser.Utility.getFlags();

        for (IOption ifd : ide){
            System.out.println(ifd.get_expression());
        }

        for (IFlag ff : fld){
           System.out.println( ff.get_meaningfulName());
        }
    }


}

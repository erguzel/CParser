package com.prs.test;

import com.prs.abstraction.ConstraintTypes;
import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.model.CmdParser;
import com.prs.abstraction.model.DefinedOption;
import com.prs.abstraction.model.Option;

public class Run {

    public static void main(String []args) throws Exception {

        CmdParser cm = new CmdParser();
        cm.AddOption("np",String.class,ConstraintTypes.Mandatory)
                .multipleValues(true)
                .valueSeparator(" ")
                .submit("Number Of Players")
                .parse(args);

        for(DefinedOption o : CmdParser.Utility.getOptions()){

            System.out.println(o.get_meaningfulName());
        }





    }
}

package com.prs.test;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.main.CParser;
import com.prs.main.DefinedFlag;
import com.prs.main.DefinedOption;

public class Run {

    public static void main(String []args) throws Exception {

        CParser cm = new CParser();
        cm.AddOption("np",String.class,ConstraintTypes.Optional)
                .multipleValues("-")
                .submit("Number Of Players")
                .AddOption("st",ConstraintTypes.class,ConstraintTypes.Mandatory)
                .submit("number of threads")
                .AddFlag("asd")
                .submit("clock display")
                .parse(args);

        for(DefinedOption o : CParser.Utility.getOptions()){

            System.out.println(o.get_expression() + "--" + o.get_meaningfulName());
        }

        for(DefinedFlag f : CParser.Utility.getFlags()){

            System.out.println(f.get_expression() + "- " + f.get_meaningfulName());
        }


    }
}

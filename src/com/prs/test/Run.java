package com.prs.test;

import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.model.CmdParser;

public class Run {

    public static void main(String []args){

        CmdParser cm = new CmdParser();
        cm.AddOption("asd",Integer.class,"asd")
                .multipleValues(true)
                .valueSeparator(" ")
                .submit("FileDirectory")
                .AddFlag("asd","none")
                .submit("IsStatistics")
                .AddOption("x",String.class,"asd")
                .multipleValues(false)
                .submit("FileName")
                .parse();

    }
}

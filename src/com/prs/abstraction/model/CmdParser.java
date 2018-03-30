package com.prs.abstraction.model;

import com.prs.abstraction.ConstraintTypes;
import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IFlagged;
import com.prs.abstraction.interfaces.IOptioned;

import java.util.ArrayList;
import java.util.List;

public class CmdParser implements ICmdParser {

    private  List<Option> _options = new ArrayList<Option>();

    private  List<Flag> _flags = new ArrayList<Flag>();

    private Option _option;

    @Override
    public IOptioned AddOption(String expressio, Class type, ConstraintTypes constraint) {

        _option = new Option(expressio,type,constraint);
        return _option;
    }

    @Override
    public IFlagged AddFlag(String expression, ConstraintTypes constraint) {
        return null;
    }

    @Override
    public void parse(String[] args) {

    }

    public static class Utility{

      private static List<DefinedOption> submittedOptions = new ArrayList<>();

         static void addOption(DefinedOption opt){

            submittedOptions.add(opt);

        }

        public static List<DefinedOption> getOptions() throws Exception {

             if(submittedOptions.isEmpty()){

                 throw new Exception("No option defined for this application yet");

             }

            return submittedOptions;
        }


    }
}

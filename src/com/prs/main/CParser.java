package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IFlagged;
import com.prs.abstraction.interfaces.IOptioned;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CParser implements ICmdParser {

    private  List<Option> _options = new ArrayList<Option>();

    private  List<Flag> _flags = new ArrayList<Flag>();

    private Option _option;

    private Flag _flag ;

    @Override
    public IOptioned AddOption(String expressio, Class type, ConstraintTypes constraint) {

        _option = new Option(expressio,type,constraint);
        return _option;
    }

    @Override
    public IFlagged AddFlag(String expression) {
        _flag = new Flag(expression);
        return _flag;
    }

    @Override
    public void parse(String[] args) throws Exception {

        checkUnsupported(args);

        checkIfFirstElementIsOptionOrFlag(args[0]);

        //parseOptions(args);

        //parseFlags(args);

    }

    private void checkUnsupported(String[] args) throws Exception {

        for (String arg : args){

            if(arg.trim().startsWith("-")){

                if(!CParser.Utility.getOptions().stream().map(a->a.get_expression()).collect(Collectors.toList()).contains(arg)){
                    throw new Exception("Error:..."+arg+" parameter does not supported yet");
                }

            }

        }


    }

    private void checkIfFirstElementIsOptionOrFlag(String firstElement) throws Exception {
        if(!firstElement.startsWith("-")){

            throw new Exception("Error:..." + " values without an option is not accepted");

        }
    }


    public static class Utility{

      private static List<DefinedOption> submittedOptions = new ArrayList<>();

      private static List<DefinedFlag> submittedFlags = new ArrayList<>();

        public static void addOption(DefinedOption opt){

            submittedOptions.add(opt);

        }

        public static void addFlag(DefinedFlag flg){

             submittedFlags.add(flg);
        }

        public static List<DefinedFlag> getFlags() throws Exception {


            if(submittedFlags.isEmpty()){

                throw new Exception("No option defined for this application yet");

            }

            return submittedFlags;

        }

        public static List<DefinedOption> getOptions() throws Exception {

             if(submittedOptions.isEmpty()){

                 throw new Exception("No option defined for this application yet");

             }

            return submittedOptions;
        }


    }
}

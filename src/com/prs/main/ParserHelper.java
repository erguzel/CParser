package com.prs.main;

import com.prs.abstraction.interfaces.IOption;

import java.util.List;
import java.util.stream.Collectors;

public class ParserHelper {

    public static void checkUnsupported(String[] args) throws Exception {

        List<String > _suportedList = CParser.Utility.getOptions()
                .stream()
                .map(a->a.get_expression())
                .collect(Collectors.toList());

        _suportedList.addAll(CParser.Utility.getFlags().stream()
                .map(c->c.get_expression())
                .collect(Collectors.toList()));

        for (String arg : args){

            if(arg.trim().startsWith("-")){

                if(!_suportedList.contains(arg.trim())){

                    boolean isKvP;

                    isKvP = CParser.Utility.getKvPairs().stream()
                            .anyMatch(a->arg.startsWith(a.get_expression()));

                    if(!isKvP){
                        throw new Exception("Error:..."+arg+" argument does not supported yet");
                    }

                }

            }

        }


    }

    public static void checkIfFirstElementIsOptionOrFlag(String firstElement) throws Exception {
        if(!firstElement.startsWith("-")){

            throw new Exception("Error:..." + " values without an option is not accepted");

        }
    }

    public static void checkEmptyParams(String [] args) throws Exception {

        if(args.length ==0){

            throw new Exception("Error:.. There are no arguments to parse");

        }

    }

    public static void checkValueFreeOptions(String [] args) throws Exception {
        String arg;
        boolean isProvidedOption;
        boolean flag=false;
        boolean isExistingOption;

        for(int s = 0; s<args.length; s++){

            arg = args[s];

            isProvidedOption = args[s].startsWith("-");
            isExistingOption = CParser.Utility.getOptions().stream().map(a->a.get_expression()).collect(Collectors.toList()).contains(arg);

            if(isProvidedOption & isExistingOption){

                if(flag){

                    throw new Exception("option without value is not accepted");

                }
                flag = true;
                continue;
           }
           else {flag = false;}

            System.out.println(arg);
        }
        if (flag){

            throw new Exception("option without value is not accepted");
        }

    }

    public static void parseOptions(String[] args) throws Exception {

        boolean isOption=false;
        boolean isFlag = false;
        IOption df;
        for (String arg: args){

             if(arg.trim().startsWith("-")){

                 isOption = CParser.Utility.getOptions()
                         .stream()
                         .map(a->a.get_expression())
                         .anyMatch(b->b.contains(arg.trim()));

                 isFlag = CParser.Utility.getFlags()
                         .stream()
                         .map(a->a.get_expression())
                         .anyMatch(b->b.contains(arg.trim()));

                 continue;
             }

            if(isOption){

               System.out.println("We are jhee");

            }


        }
    }

    private static void parseFlgs(String[] arg){


    }



}

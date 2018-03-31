package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserHelper {

    public static void checkUnsupported(String[] args) throws Exception {

        List<String> _suportedList = CParser.Utility.getOptions()
                .stream()
                .map(a -> a.get_expression())
                .collect(Collectors.toList());

        _suportedList.addAll(CParser.Utility.getFlags().stream()
                .map(c -> c.get_expression())
                .collect(Collectors.toList()));

        for (String arg : args) {

            if (arg.trim().startsWith("-")) {

                if (!_suportedList.contains(arg.trim())) {

                    boolean isKvP;

                    isKvP = CParser.Utility.getKvPairs().stream()
                            .anyMatch(a -> arg.startsWith(a.get_expression()));

                    if (!isKvP) {
                        throw new Exception("Error:..." + arg + " argument does not supported yet");
                    }

                }

            }

        }


    }

    public static void checkIfFirstElementIsOptionOrFlag(String firstElement) throws Exception {
        if (!firstElement.startsWith("-")) {

            throw new Exception("Error:..." + " values without an option is not accepted");

        }
    }

    public static void checkEmptyParams(String[] args) throws Exception {

        if (args.length == 0) {

            throw new Exception("Error:.. There are no arguments to parse");

        }

    }

    public static void checkValueFreeOptions(String[] args) throws Exception {
        String arg;
        boolean isProvidedOption;
        boolean flag = false;
        boolean isExistingOption;

        for (int s = 0; s < args.length; s++) {

            arg = args[s];

            isProvidedOption = args[s].startsWith("-");
            isExistingOption = CParser.Utility.getOptions().stream().map(a -> a.get_expression()).collect(Collectors.toList()).contains(arg);

            if (isProvidedOption & isExistingOption) {

                if (flag) {

                    throw new Exception("option without value is not accepted");

                }
                flag = true;
                continue;
            } else {
                flag = false;
            }

        }
        if (flag) {

            throw new Exception("option without value is not accepted");
        }

    }

    public static void parseOptions(String[] args) throws Exception {

        boolean isOption = false;
        String optionExpression = " ";

        for (String arg : args) {

            if (arg.trim().startsWith("-")) {

                isOption = CParser.Utility.getOptions()
                        .stream()
                        .map(a -> a.get_expression())
                        .anyMatch(b -> b.contains(arg.trim()));

                optionExpression = arg;

                continue;
            }

            if (isOption) {

                String finalOptionExpression = optionExpression;

                if (CParser.Utility.getOptions().stream().filter(a -> a.get_expression().equals(finalOptionExpression)).findAny().get().get_valueSeparator().equals(" ")) {

                    CParser.Utility.getOptions().stream()
                            .filter(x -> x.get_expression().equals(finalOptionExpression))
                            .collect(Collectors.toList())
                            .forEach(a -> a.addValue(arg.trim()));

                } else {

                    String[] values;

                    String valueSeparator = CParser.Utility.getOptions()
                            .stream()
                            .filter(a -> a.get_expression().equals(finalOptionExpression))
                            .findAny()
                            .get()
                            .get_valueSeparator();
                    if (arg.contains(valueSeparator)) {
                        values = arg.trim().split(valueSeparator.trim());

                    } else {

                        throw new Exception("Error:... Defined " + "'".concat(valueSeparator).concat("'") + " and provided value separator does not match");
                    }


                    CParser.Utility.getOptions().stream()
                            .filter(a -> a.get_expression().equals(finalOptionExpression))
                            .forEach(x -> x.addValueRange(values));

                }

            }

        }

    }

    public static void parseKvP(String[] args) throws Exception {

        boolean isKvP = false;
        String kvpExpression = " ";

        for (String arg : args) {

            if (arg.trim().startsWith("-")) {

                isKvP = CParser.Utility.getKvPairs().stream()
                        .anyMatch(a -> arg.startsWith(a.get_expression()));

                if (isKvP) {

                    kvpExpression = arg.trim();

                    String finalKvPExpression = kvpExpression;

                    String valueSeparator = CParser.Utility.getKvPairs()
                            .stream()
                            .filter(a ->arg.startsWith(a.get_expression()))
                            .findAny()
                            .get()
                            .get_valueSeparator();


                    String[] values;

                    if (arg.contains(valueSeparator)) {

                        values = arg.trim().split(valueSeparator.trim());

                    } else {

                        throw new Exception("Error:... Defined " + "'".concat(valueSeparator).concat("'") + " and provided value separator does not match");
                    }

                    CParser.Utility.getKvPairs().stream()
                            .filter(a -> arg.startsWith(a.get_expression()))
                            .forEach(x -> x.setValue(values[1]));

                }

            }

        }

    }

    /*
    TODO
     */
    private static void parseFlgs(String[] args) {

        boolean isFlag = false;
        String flagExpression = " ";

        for (String arg : args) {

            if (arg.startsWith("-")) {

                isFlag = CParser.Utility.getFlags()
                        .stream()
                        .map(a -> a.get_expression())
                        .anyMatch(b -> b.contains(arg.trim()));

                flagExpression = arg.trim();

                if (isFlag) {

                    String finalflagExpression = flagExpression;


                }
            }


        }

    }

    public static void checkMandatories(String[] args) throws Exception {

        boolean anyMandatoryOption = CParser.Utility.getOptions().stream()
                .anyMatch(a->a.getcType() == ConstraintTypes.Mandatory);

        if(anyMandatoryOption){

            List<String > mandatories = CParser.Utility.getOptions().stream()
                    .filter(a->a.getcType() == ConstraintTypes.Mandatory)
                    .map(b->b.get_expression())
                    .collect(Collectors.toList());


            mandatories.addAll(CParser.Utility.getKvPairs().stream()
            .filter(a->a.getcType() == ConstraintTypes.Mandatory)
            .map(b->b.get_expression()).collect(Collectors.toList()));

            List<String> allOptions = new ArrayList<>();
            for(String s : args){

                if(s.trim().startsWith("-")){

                    allOptions.add(s);

                }

            }

            if(!allOptions.containsAll(mandatories)){

                StringBuilder sb = new StringBuilder();

                mandatories.forEach(a->sb.append(a).append(" "));

             throw new Exception("Error:... Mandatory "+ sb.toString()  + " options omited");

            }

        }


    }
}

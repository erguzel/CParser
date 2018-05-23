package com.prs.main;

import abstraction.cpar.enumic.ArgumentTypes;
import abstraction.cpar.enumic.ConstraintTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserHelper {

    private static List<String> _arguments = new ArrayList<>();

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
                            .map(a->a.get_expression()).collect(Collectors.toList()).stream()
                    .anyMatch(b->arg.contains(b));

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

    public static void checkValueFreeOptions(String[] args) throws Exception {



    }

    public static void parseOptions(String[] args) throws Exception {

        boolean isOption = false;
        String optionExpression = " ";

        for (String arg : args) {

            if (arg.trim().startsWith("-")) {

                isOption = CParser.Utility.getOptions()
                        .stream()
                        .map(a -> a.get_expression())
                        .anyMatch(b -> b.equals(arg.trim()));

                optionExpression = arg.trim();

                continue;
            }

            if (isOption) {

                String finalOptionExpression = optionExpression;

                if (CParser.Utility.getOptions().stream().filter(a -> a.get_expression().equals(finalOptionExpression)).findAny().get().get_valueSeparator().equals(" ")) {

                    CParser.Utility.getOptions().stream()
                            .filter(x -> x.get_expression().equals(finalOptionExpression))
                            .collect(Collectors.toList())
                            .forEach(a -> {
                                try {
                                    a.addValue(arg.trim());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.exit(1);
                                }
                            });

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
                            .forEach(x -> {
                                try {
                                    x.addValueRange(values);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.exit(1);
                                }
                            });

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

                    String finalKvPExpression = arg.trim();

                    String valueSeparator = CParser.Utility.getKvPairs()
                            .stream()
                            .filter(a -> arg.startsWith(a.get_expression()))
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
                            .forEach(x -> {
                                try {
                                    x.setValue(values[1]);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.exit(1);
                                }
                            });

                }

            }

        }

    }

    /*
    TODO
     */
    public static void parseFlags(String[] args) {

        boolean isFlag = false;
        String flagExpression = " ";

        for (String arg : args) {

            if (arg.startsWith("-")) {

                isFlag = CParser.Utility.getFlags()
                        .stream()
                        .map(a -> a.get_expression())
                        .anyMatch(b -> b.equals(arg.trim()));



                if (isFlag) {

                    String finalflagExpression = arg.trim();

                    CParser.Utility.getFlags().stream()
                            .filter(a -> a.get_expression().equals(finalflagExpression))
                            .forEach(a -> {
                                try {
                                    a.setValue(true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });


                }
            }


        }

    }

    public static void checkMandatories(String[] args) throws Exception {

        boolean anyMandatoryOption = CParser.Utility.getOptions().stream()
                .anyMatch(a -> a.getcType() == ConstraintTypes.Mandatory);

        if (anyMandatoryOption) {

            List<String> mandatories = CParser.Utility.getOptions().stream()
                    .filter(a -> a.getcType() == ConstraintTypes.Mandatory)
                    .map(b -> b.get_expression())
                    .collect(Collectors.toList());


            mandatories.addAll(CParser.Utility.getKvPairs().stream()
                    .filter(a -> a.getcType() == ConstraintTypes.Mandatory)
                    .map(b -> b.get_expression()).collect(Collectors.toList()));

            boolean isMandatoriesSatisfied;

            isMandatoriesSatisfied =  mandatories.stream().allMatch(a->_arguments.stream().anyMatch(b->b.contains(a)));

            if (!isMandatoriesSatisfied) {

                StringBuilder sb = new StringBuilder();

             mandatories.stream().filter(a->_arguments.stream().noneMatch(b->b.contains(a))).collect(Collectors.toList())
                     .forEach(x->sb.append(x).append(" "));

                throw new Exception("Error:... Mandatory " + sb.toString() + " option(s) omited");

            }

        }


    }

    public static void parseNakedValues(String[] args) {

        boolean IsoptOrKvpVal =false;
        boolean isFlag;
        boolean isNakedVal = false;

        List<String > _optionOrKvp = Stream.of(CParser.Utility.getOptions().stream()
                        .map(x->x.get_expression()).collect(Collectors.toList()),
                CParser.Utility.getKvPairs().stream()
                        .map(a->a.get_expression()).collect(Collectors.toList()))
                .flatMap(Collection::stream).collect(Collectors.toList());

        for (String arg : args) {


            if(_optionOrKvp.contains(arg.trim()) || _optionOrKvp.stream().anyMatch(a->arg.contains(a))){

                IsoptOrKvpVal = true;
                continue;
            }

            if(CParser.Utility.getFlags().stream().anyMatch(a->a.get_expression().equals(arg.trim()))){
                IsoptOrKvpVal =false;
                isFlag =true;
                continue;
            }


            if(!IsoptOrKvpVal){

                CParser.Utility.addNakedValue(arg.trim());
            }

        }
    }

    public static void prepareArgs(String[] args) {

        for(String arg : args){

            _arguments.add(arg);

        }

    }

    private static boolean isWhat(ArgumentTypes argType, String argument) throws Exception {

        boolean result = false;

        switch (argType){

            case Flag:

                result = CParser.Utility.getFlags().stream()
                        .anyMatch(a->a.get_expression().equals(argument.trim()));

            case Option:

                result = CParser.Utility.getOptions().stream()
                        .anyMatch(a->a.get_expression().equals(argument.trim()));

            case KeyValuePair:

                result = CParser.Utility.getKvPairs().stream()
                        .anyMatch(a->a.get_expression().startsWith(argument.trim()));
            case NakedValue:

                result = argument.startsWith(argument.trim())? false : true;
                default:

                    throw new Exception("Given argument type is not defined in the enum");


        }
    }
}

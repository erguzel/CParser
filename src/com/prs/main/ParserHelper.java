package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserHelper {

    public static final String RgxAlfanumeric = "[a-zA-Z0-9]+$";

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
                            .anyMatch(a -> arg.trim().equals(a.get_expression()));

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
            String val = resolveRegex(arg, RgxAlfanumeric);
            isExistingOption = CParser.Utility.getOptions().stream().map(a -> a.get_expression()).collect(Collectors.toList()).contains(val);

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

                    kvpExpression = resolveRegex(arg, RgxAlfanumeric);

                    String finalKvPExpression = kvpExpression;

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

                flagExpression = resolveRegex(arg, RgxAlfanumeric);

                if (isFlag) {

                    String finalflagExpression = flagExpression;

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

            List<String> allOptions = new ArrayList<>();
            for (String s : args) {

                if (s.trim().startsWith("-")) {

                    String val = resolveRegex(s, RgxAlfanumeric);

                    allOptions.add(val);

                }

            }

            if (!allOptions.containsAll(mandatories)) {

                StringBuilder sb = new StringBuilder();

                mandatories.forEach(a -> sb.append(a).append(" "));

                throw new Exception("Error:... Mandatory " + sb.toString() + " options omited");

            }

        }


    }

    private static String resolveRegex(String sample, String regex) {

        Pattern patern = Pattern.compile(regex);
        Matcher mher = patern.matcher(sample);

        boolean ismatched = mher.find();

        return mher.group(0);
    }

    public static void parseNakedValues(String[] args) {

        boolean optOrKvpVal =false;
        boolean isFlag;
        boolean isNakedVal = false;

        List _optionOrKvp = Stream.of(CParser.Utility.getOptions().stream()
                        .map(x->x.get_expression()).collect(Collectors.toList()),
                CParser.Utility.getKvPairs().stream()
                        .map(a->a.get_expression()).collect(Collectors.toList()))
                .flatMap(Collection::stream).collect(Collectors.toList());


        for (String arg : args) {

            isFlag = CParser.Utility.getFlags().stream().anyMatch(a->a.get_expression().equals(arg.trim()));

            if(_optionOrKvp.contains(arg.trim())){

                optOrKvpVal = true;
                continue;
            }

            if(isFlag){
                optOrKvpVal =false;
                continue;
            }

            if(!optOrKvpVal){

                CParser.Utility.addNakedValue(arg.trim());
            }

        }
    }
}

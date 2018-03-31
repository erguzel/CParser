package com.prs.main;

import com.prs.abstraction.enumic.ConstraintTypes;
import com.prs.abstraction.interfaces.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CParser implements ICmdParser {

    private  List<OptionHandler> _optionHandlers = new ArrayList<OptionHandler>();

    private  List<FlagHandler> _flagHandlers = new ArrayList<FlagHandler>();

    private OptionHandler _optionHandler;

    private FlagHandler _flagHandler;

    private KeyValPairHandler _kvHandler;

    @Override
    public IOptioned AddOption(String expressio, Class<? extends Object> type, ConstraintTypes constraint) throws Exception {

        _optionHandler = new OptionHandler(expressio,type,constraint);
        return _optionHandler;
    }

    @Override
    public IFlagged AddFlag(String expression) throws Exception {

        if (CParser.Utility.getFlags().stream().map(a->a.get_expression()).collect(Collectors.toList()).contains(expression)){

            throw  new  Exception(" Error:..." + expression + " option already defined");
        }

        _flagHandler = new FlagHandler(expression);
        return _flagHandler;
    }

    @Override
    public IKeyValuePaired AddKeyValuePair(String expression, String valueSeparator, Class<? extends Object> dataType, ConstraintTypes consTypee) {

        _kvHandler = new KeyValPairHandler(expression,valueSeparator,dataType,consTypee);

        return _kvHandler;
    }

    @Override
    public void parse(String[] args) throws Exception {

        ParserHelper.checkEmptyParams(args);

        ParserHelper.checkUnsupported(args);

        ParserHelper.checkIfFirstElementIsOptionOrFlag(args[0]);

        ParserHelper.checkValueFreeOptions(args);

        ParserHelper.checkMandatories(args);

        ParserHelper.parseOptions(args);

        ParserHelper.parseKvP(args);

        //ParserHelper.parseFlags(args);

    }
    public static class Utility{

      private static List<IOption> submittedOptions = new ArrayList<>();

      private static List<IFlag> submittedFlags = new ArrayList<>();

      private static List<IKeyValPair> sublittedKVPairs = new ArrayList<>();

         static void addOption(IOption opt){

            submittedOptions.add(opt);

        }

         static void addFlag(Flag flg){

             submittedFlags.add(flg);
        }

        static void addKvP(IKeyValPair kevalpair){

             sublittedKVPairs.add(kevalpair);
        }

        public static List<IFlag> getFlags() {

            return submittedFlags;

        }

        public static List<IOption> getOptions()  {

            return submittedOptions;
        }

        public static List<IKeyValPair> getKvPairs(){

            return sublittedKVPairs;
        }


    }
}

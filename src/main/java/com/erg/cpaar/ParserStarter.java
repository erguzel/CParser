package com.erg.cpaar;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CmdParsing engine for generic applications.
 */
public class ParserStarter {

    /**
     * Represents original cmd arguments as concatinated string.
     */
    private String _cmdArgTrain="";

    private static List<String> CMD_ARGUMENTS = new ArrayList<>();

    /**
     * Represents the output values ofter cmd parsing.
     */
    public static class ParsedOutputs{
        /**
         * Represents CmdOptions and its values
         */
        public static Map<Object,List<Object>> CmdOptions = new HashMap<>();
        /**
         * Represents CmdFlags with its values
          */
        public static Map<Object,Boolean> CmdFlags = new HashMap<>();
        /**
         * Represents CmdKeyValyePairs with its values
         */
        public static Map<Object,List<Object>> CmdKeyValuePairs = new HashMap<>();
    }

    /**
     * Original CmdArguments
     */
    private List<CmdArgument> ARGUMENTS_TO_PARSE = new ArrayList();

    /**
     * Add Option to program rule.
     * @param option Object
     * @return ParserStarterObject
     */
    public ParserStarter AddOption(CmdOption option){

        ARGUMENTS_TO_PARSE.add(option);
        return this;

    }

    /**
     * Add Flag rule to program.
     * @param flag object
     * @return ParserStarterObject
     */
    public ParserStarter AddFlag(CmdFlag flag){

        ARGUMENTS_TO_PARSE.add(flag);
        return this;

    }

    /**
     * Add keyValuePair as program input rule.
     * @param keyValuePair object
     * @return ParserStarterObject
     */
    public ParserStarter AddKeyValuePair(CmdKeyValuePair keyValuePair){

        ARGUMENTS_TO_PARSE.add(keyValuePair);
        return  this;

    }

    /**
     * Parses ArgumentObjects according to encapsulated parsing logic in ArgumentObjects.
     * @param args as original program arguments
     * @throws com.erg.exc.cmdparser.MandatoryArgumentNotProvidedException
     */
    public void Parse(String [] args) throws MandatoryArgumentNotProvidedException {

        for(String arg : args){

            this._cmdArgTrain = this._cmdArgTrain.concat(arg+" ");
        }


        for (CmdArgument cmdar: ARGUMENTS_TO_PARSE){

            cmdar.Parse(this._cmdArgTrain);
        }
    }
}

package com.erg.cpaar;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Represents a CmdArgument as CmdOption. CmdOption is a kind of argument that can have multiple values as
 * i.e. app.exe -f file/to/path.1 file/to/path2 ...
 */
public class CmdOption extends CmdArgument {

    /**
     * Represents the argument code i.e. -f
     */
    private Object _argCode = null;
    /**
     * Represents the data type of the values of this option. Usually string.
     */
    private Class _dataType = null;
    /**
     * Represents if this option is mandatory for application.
     */
    private boolean _isMandatory = false;
    /**
     * Represents the human readable name of this option.
     */
    private Object _Name;

    /**
     * Creates an instance of CmdOption. CmdOption is a kind of argument that can have multiple values as
     * i.e. app.exe -f file/to/path.1 file/to/path2 ...
     * @param name of the option
     * @param argumentCode of the option
     * @param dataType of the option values
     * @param isMandatory true if option is mandatory for the app
     */
    public CmdOption(Object name, Object argumentCode, Class dataType, boolean isMandatory) {
        super(name, argumentCode);
        this._Name = name;
        this._argCode = argumentCode;
        this._dataType = dataType;
        this._isMandatory = isMandatory;
    }

    /**
     * Parses the option values.
     * @param args String concatinated original cmd arguments
     * @throws com.erg.cpaar.MandatoryArgumentNotProvidedException
     */
    @Override
    public void Parse(String args) throws com.erg.cpaar.MandatoryArgumentNotProvidedException {

        boolean isMatching = true;

        List<Object> values = new ArrayList<>();

        Pattern pt = Pattern.compile(this._argCode.toString());
        /**
         * Check if argument code is in original cmd argument set.
         */
        if (!Pattern.compile(this._argCode.toString()).matcher(args).find()) {

            if (_isMandatory) {

                throw new MandatoryArgumentNotProvidedException("There is an option which is mandatory for program to run but you did not provide it.", true, (String) _argCode, "Nothing");
            }

            isMatching = false;
        }

        if(isMatching){

            /**
             * Put argument set in a list.
             */
            List<String> argus = Arrays.asList(args.split("\\s"));

            /**
             * Start index of a value of this option.
             */
            int startindex = 0;
            /**
             * Find the first argument code in cmd argument set.
             */
            startindex =   argus.indexOf(this.getGivenArgCode())+1;
            /**
             * Loop till finding another argument which starts with -
             * or till the end of the argument set.
             */
            for (int i = startindex; i <(argus.size()); i++){

                if(argus.get(i).startsWith("-") | i == args.length()-1){

                    break;
                }

                String var =argus.get(i).trim();
                values.add(var);
            }

            /**
             * Add the option name and its values to a global Map
             */
            ParserStarter.ParsedOutputs.CmdOptions.put(this.getGivenName(),values);

        }
    }
}

package com.erg.cpaar;


import java.util.regex.Pattern;

/**
 * Represents a Cmd flag. i.e. -sot as IsSaveOcrText
 */
public class CmdFlag extends CmdArgument {
    /**
     * Represents if this CmdArgument is a mandatory one.
     */
    private  boolean _isMandatory;

    /**
     * Represents a CmdArgument inherited as CmdFlag.
     * @param name of the Flag function
     * @param argCode of the Flag
     * @param isMandatory True if mandatory
     */
    public CmdFlag(Object name, Object argCode, boolean isMandatory){
        super(name,argCode);
        _isMandatory = isMandatory;

    }

    /**
     * Parses argument flag.
     * @param args String concatinated original cmd arguments
     * @throws com.erg.cpaar.MandatoryArgumentNotProvidedException
     */
    @Override
    public void Parse(String args) throws com.erg.cpaar.MandatoryArgumentNotProvidedException {

        boolean isFound = true;
        /**
         * Check if argument code is in original cmd argument set.
         */
        if(!Pattern.compile(this.getGivenArgCode().toString()).matcher(args).find()){

            if (_isMandatory) {

                throw new MandatoryArgumentNotProvidedException("There is an option which is mandatory for program to run but you did not provide it.",true,this.getGivenArgCode().toString(),"Nothing");
            }

            isFound = false;

        }
        /**
         * Add parsed argument and its value to global Parsed flag Map.
         */
        ParserStarter.ParsedOutputs.CmdFlags.put(this.getGivenName(),isFound);
    }
}

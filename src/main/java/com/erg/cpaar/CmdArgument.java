package com.erg.cpaar;

import com.erg.cpaar.MandatoryArgumentNotProvidedException;

/**
 * Represents a base class for any kind of cmd argument: Option, Flag, KeyValuePair
 */
public abstract class CmdArgument {
    /**
     * Argument code as -f or -sot
     */
    private Object _argCode = null;
    /**
     * Argument human readable name as Files or IsSaveMode
     */
    private Object _name;

    /**
     * Creates an instance of CmdArgument object
     * @param name Human readable name of argument function
     * @param argumentCode Argument code i.e. -f or -rot
     */
    public CmdArgument(Object name, Object argumentCode){
        this._argCode = argumentCode;
        this._name = name;
    }

    public Object getGivenName(){
        return this._name;
    }

    /**
     * Returns human readable name of argument function.
     * @return Name of the argument.
     */
    public Object getGivenArgCode(){
        return this._argCode;
    }

    /**
     * Parses the argument according to the logic defined in each inherited classes.
     * @param args String concatinated original cmd arguments
     * @throws com.erg.exc.cmdparser.MandatoryArgumentNotProvidedException
     */
    public abstract void Parse(String args) throws MandatoryArgumentNotProvidedException;

}

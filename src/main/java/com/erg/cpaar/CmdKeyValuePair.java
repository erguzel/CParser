package com.erg.cpaar;

public class CmdKeyValuePair extends CmdArgument {

    private  boolean _isMandatory;
    private  Class _dataType;

    public CmdKeyValuePair(Object name, Object argumentCode, Class dataType, boolean isMandatory){
        super(name,argumentCode);

    }

    @Override
    public void Parse(String args) {

    }
}

package com.erg.cpaar.prepare;

import com.erg.cpaar.abstraction.data.raw.*;
import com.erg.cpaar.abstraction.prepare.*;

public class Added implements IAdded {


    private IFileList _pathList;
    private IArgument _argument;
    private IFlag _flag;
    private IOption _option;
    private INumberlist _numberList;
    private String _keyName;


    private boolean IsOption;
    private boolean Isflag;
    private boolean isNumberList;
    private boolean isPathList;

    @Override
    public ISubmitted submit(String keyName) throws Exception {

        if(IsOption){
            _option.setName(keyName);
            return new Submitted(_option);
        }
        else if(Isflag){
            _flag.setName(keyName);
            return new Submitted(_flag);
        }

        if(isNumberList){

            return new Submitted(_numberList);
        }

        return new Submitted();// thread never must come here
    }

    public Added(IArgument argument) {
        _argument = argument;

    }

    public Added(IFlag flag){

        _flag = flag;
        Isflag = true;

    }

    public Added(IOption option) {

        _option = option;
        IsOption = true;
    }

    public Added(INumberlist numberList){
        _numberList = numberList;
        isNumberList = true;

    }

    public Added(IFileList pathList){
        _pathList = pathList;
        isPathList = true;
    }
}

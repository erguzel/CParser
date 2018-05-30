package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.prepare.*;

public class Added implements IAdded {


    private IArgument _argument;
    private IFlag _flag;
    private IOption _option;
    private String _keyName;


    private boolean IsOption;
    private boolean Isflag;

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
}

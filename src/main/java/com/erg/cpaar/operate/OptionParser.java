package com.erg.cpaar.operate;


import com.erg.abst.cpaar.data.raw.IOption;
import com.erg.cpaar.data.Arguments;
import com.erg.cpaar.data.processed.ParsedOption;

import java.util.List;

public class OptionParser {
    private boolean isOption = false;
    public OptionParser(String name, IOption element) throws Exception {

        if(!Arguments._args.isEmpty()){

            //check mandatory
            if(element.isMandatory()){
                if(!Arguments._args.contains(element.getExpression())){
                    throw new Exception("Mandatory " + element.getExpression() +" " + "Option has to be provided");
                }
            }

            //
            //
            for (String s: Arguments._args){

                if(s.trim().equals(element.getExpression())){
                    isOption = true;
                    continue;
                }

                if(!s.trim().equals(element.getExpression()) && s.startsWith("-")){

                    isOption = false;
                    continue;
                }

                if(isOption){

                    //typeConverterelement.getDataType()

                }
            }
        }





    }
}

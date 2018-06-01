package com.erg.cpaar.operate;

import com.erg.abst.cpaar.prepare.IOption;
import com.erg.abst.global.IExecutable;
import com.erg.abst.global.IObject;
import com.erg.cpaar.data.Inputs;
import com.erg.cpaar.data.Outputs;
import com.erg.util.parse.TypeParser;

import java.util.ArrayList;
import java.util.List;

public class OptionParser implements IExecutable {

    private IOption _option;

    public OptionParser(IOption _option) throws Exception {
        this._option = _option;
        execute();
    }

    @Override
    public void execute() throws Exception {

        //check mandatory options
        if (_option.getIsMandatory()) {

            if (!Inputs._args.contains(_option.getRegex().trim())) {

                throw new Exception(_option.getRegex() + " is a mandatory option");
            }

        }

        List<Object> options = null;



        for (String s : Inputs._args) {

            if (s.trim().equals(_option.getRegex().trim())) {

                int currentIndex = Inputs._args.indexOf(s);
                options = new ArrayList<>();
                for (int i = currentIndex + 1; i < Inputs._args.size(); i++) {

                    if (Inputs._args.get(i).startsWith("-")) {
                        break;
                    }

                    Object val = TypeParser.ParseDataType(_option.getDataType(), Inputs._args.get(i));
                    options.add(val);

                }

                Outputs.options.put(_option.getName(), options);
            }

        }
    }
}

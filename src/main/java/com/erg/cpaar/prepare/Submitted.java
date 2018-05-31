package com.erg.cpaar.prepare;

import com.erg.abst.cpaar.BareArgumentTypes;
import com.erg.abst.cpaar.prepare.*;
import com.erg.cpaar.data.Flag;
import com.erg.cpaar.data.Inputs;
import com.erg.cpaar.data.Option;
import com.erg.cpaar.operate.FlagParser;
import com.erg.cpaar.operate.NumberParser;
import com.erg.cpaar.operate.OptionParser;
import com.erg.util.datatype.TypeParser;

import java.util.List;
import java.util.stream.Collectors;

public class Submitted implements ISubmitted {

    private IOption _option;
    private IFlag _flag;
    private IArgument _arg;
    private INumberlist _nums;



    public Submitted(IFlag flag){

        _flag = flag;
        Inputs.Flags.add(_flag);
    }

    public Submitted(IOption option){
        _option = option;
        Inputs.Options.add(_option);
    }
    public Submitted(INumberlist numList){
        _nums = numList;
        Inputs.Numbers.add(numList);
    }

    public Submitted() throws Exception {

        throw new Exception("Logic error");
    }


    @Override
    public void parse(String[] args) throws Exception {

        List<String> allArguments= Inputs.Flags.stream().map(a->a.getRegex()).collect(Collectors.toList());

        allArguments.addAll( Inputs.Options.stream().map(a->a.getRegex()).collect(Collectors.toList()));

        for(String s : args){

            if(!TypeParser.isInteger(s)){

                if(s.trim().startsWith("-")){

                    if(!allArguments.contains(s)){

                        throw new Exception(" Undefined arguments detected. Quitting..");

                    }
                }

            }

            Inputs._args.add(s);
        }
        //
        // Pars flags
        //
        Inputs.Flags.forEach(a->new FlagParser(a));

        //
        // Parse Options
        //
        Inputs.Options.forEach(a -> {
            try {

                new OptionParser(a);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });

        Inputs.Numbers.forEach(b -> {
            try {
                new NumberParser(b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



    }


    @Override
    public IAdded add(Class<?> dataType, BareArgumentTypes argType) {
        return null;
    }

    @Override
    public IAdded addOption(String regex, Class<?> dataType, boolean isMandatory) {

        return  new Added(new Option(regex,dataType,isMandatory));
    }

    @Override
    public IAdded addFlag(String regex) {
        return new Added(new Flag(regex));
    }
}

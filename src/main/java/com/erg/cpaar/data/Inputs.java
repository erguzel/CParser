package com.erg.cpaar.data;

import com.erg.abst.cpaar.prepare.IArgument;
import com.erg.abst.cpaar.prepare.IFlag;
import com.erg.abst.cpaar.prepare.INumberlist;
import com.erg.abst.cpaar.prepare.IOption;

import java.util.*;

public class Inputs {

    public static LinkedHashSet<IOption> Options = new LinkedHashSet<>();
    public static LinkedHashSet<IFlag> Flags = new LinkedHashSet<>();
    public static List<INumberlist> Numbers = new ArrayList<>();
    public static List<String> _args = new ArrayList<>();

}

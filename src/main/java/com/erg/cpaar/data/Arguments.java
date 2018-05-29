package com.erg.cpaar.data;

import com.erg.abst.cpaar.data.processed.IParsedOption;
import com.erg.abst.cpaar.data.raw.IOption;

import java.util.*;

public class Arguments {

    public static Map<String, IOption> Options = new HashMap<>();
    public static Hashtable<String,List<?> >parsedOptions = new Hashtable<>();
    public static List<String> _args = new ArrayList<>();

}

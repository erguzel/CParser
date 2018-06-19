package com.erg.cpaar.data;

import com.erg.abst.cpaar.data.raw.IFileList;
import com.erg.abst.cpaar.data.raw.IFlag;
import com.erg.abst.cpaar.data.raw.INumberlist;
import com.erg.abst.cpaar.data.raw.IOption;

import java.util.*;

public class Inputs {

    public static LinkedHashSet<IOption> Options = new LinkedHashSet<>();
    public static LinkedHashSet<IFlag> Flags = new LinkedHashSet<>();
    public static List<INumberlist> Numbers = new ArrayList<>();
    public static List<String> _args = new ArrayList<>();
    public static List<IFileList> Files = new ArrayList<>();

}

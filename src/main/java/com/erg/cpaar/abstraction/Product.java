package com.erg.cpaar.abstraction;

import java.util.Hashtable;
import java.util.List;

public class Product {

    private static Hashtable<String,List<?>> _data = new Hashtable<>();

    private void addKvp(String key, List<?> value){

        _data.put(key,value);
    }

    private Hashtable<String ,List<?>> get_data(){
        return _data;
    }

}

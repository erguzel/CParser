package com.prs.abstraction.interfaces;

import com.prs.abstraction.enumic.ConstraintTypes;

import java.util.LinkedList;
import java.util.List;

public interface IOption extends IMultipleValued {

     String get_valueSeparator() ;

     String get_expression();

     Class get_dataType();

     ConstraintTypes getcType();

     String get_meaningfulName();

     List getValues();


}

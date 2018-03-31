package com.prs.abstraction.interfaces;

import com.prs.abstraction.enumic.ConstraintTypes;

public interface IOption extends IMultipleValued {

     String get_valueSeparator() ;

     String get_expression();

     Class get_dataType();

     ConstraintTypes getcType();

     String get_meaningfulName();


}

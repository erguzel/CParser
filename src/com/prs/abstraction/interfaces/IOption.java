package com.prs.abstraction.interfaces;

import com.prs.abstraction.enumic.ConstraintTypes;

import java.util.List;

public interface IOption extends IMultipleValued {

     String get_valueSeparator() ;

     String get_expression();

     Class<? extends Object> get_dataType();

     ConstraintTypes getcType();

     String get_meaningfulName();

     List<? extends  Object> getValues();


}

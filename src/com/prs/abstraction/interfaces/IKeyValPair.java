package com.prs.abstraction.interfaces;

import com.prs.abstraction.enumic.ConstraintTypes;

public interface IKeyValPair extends IValued {

     String get_valueSeparator() ;

     String get_expression();

     Class<? extends Object> get_dataType();

     ConstraintTypes getcType();

     String get_meaningfulName();
}

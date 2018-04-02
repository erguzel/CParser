package com.prs.abstraction.interfaces;

import com.prs.abstraction.enumic.ConstraintTypes;

import java.util.List;

public interface IOption extends IMultipleValued {
     /**
      * Gets the value separator of a multiple valued option
      * @return the value separator string
      */
     String get_valueSeparator() ;

     /**
      * Gets the expression of defined option
      * @return the expression string of a defined option
      */
     String get_expression();

     /**
      * Gets the data type accepted as a value
      * @return the class object represienting the accepted data type
      */
     Class<? extends Object> get_dataType();

     /**
      * Gets the constraint type
      * @return the constraint type of the option
      */
     ConstraintTypes getcType();

     /**
      * Gets the human readable meaning
      * @return the meaningful name
      */
     String get_meaningfulName();

     /**
      * Gets the value
      * @return the value 
      */
     List<? extends  Object> getValues();


}

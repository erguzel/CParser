package com.prs.abstraction.interfaces;

import com.prs.abstraction.enumic.ConstraintTypes;

public interface ICmdParser extends IParse {

     /**
      *
      * @param expression
      * @param dataType
      * @param constraint
      * @return IOptioned object.
      * @throws Exception OptionExistsException,
      */
     IOptioned AddOption(String expression, Class<? extends Object> dataType, ConstraintTypes constraint) throws Exception;

     /**
      *
      * @param expression
      * @return IFlagged object
      * @throws Exception
      */
     IFlagged AddFlag(String expression) throws Exception;

     /**
      *
      * @param expression
      * @param valueSeparator
      * @param dataType
      * @param consTypee
      * @return IKeyValuePaired object
      */
     IKeyValuePaired AddKeyValuePair(String expression,String valueSeparator, Class<? extends Object> dataType, ConstraintTypes consTypee);

}

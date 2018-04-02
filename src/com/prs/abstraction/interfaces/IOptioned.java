package com.prs.abstraction.interfaces;


public interface IOptioned extends ISubmit{
     /**
      * Submits the defined argument
      * @param valueSeparator
      * @return
      */
     ISubmit multipleValues(String valueSeparator);
}

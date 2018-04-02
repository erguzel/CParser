package com.prs.abstraction.interfaces;

public interface ISubmit {
     /**
      * Submits the defined argument
      * @param giveMeaningfulName
      * @return
      * @throws Exception
      */
     ICmdParser submit(String giveMeaningfulName) throws Exception;
}

package com.prs.abstraction.interfaces;

public interface IParse {
     /**
      * Parses the defined command line arguments
      * @param args
      * @throws Exception
      */
     void parse(String [] args) throws Exception;
}

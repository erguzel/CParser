package com.prs.abstraction.interfaces;


public interface IOptioned extends ISubmit{

     IOptioned multipleValues(boolean choice);
     IOptioned valueSeparator(String charSeparator);

}

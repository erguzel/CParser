package com.prs.abstraction.interfaces;

public interface ICmdParser {

     IOptioned AddOption(String name, Class type, String constraint);

     IFlagged AddFlag(String name, String constraint);
}

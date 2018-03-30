package com.prs.abstraction.interfaces;

public interface ICmdParser {

    public IOptioned addOption(String name, Class type, String constraint);

    public IFlagged addFlag(String name, String constraint);
}

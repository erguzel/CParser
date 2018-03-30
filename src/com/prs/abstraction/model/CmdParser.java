package com.prs.abstraction.model;

import com.prs.abstraction.interfaces.ICmdParser;
import com.prs.abstraction.interfaces.IFlagged;
import com.prs.abstraction.interfaces.IOptioned;

public class CmdParser implements ICmdParser {

    @Override
    public IOptioned AddOption(String name, Class type, String constraint) {
        return null;
    }

    @Override
    public IFlagged AddFlag(String name, String constraint) {
        return null;
    }
}

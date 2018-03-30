package com.prs.abstraction.model;

import com.prs.abstraction.ConstraintTypes;
import com.prs.abstraction.interfaces.IFlagged;
import com.prs.abstraction.interfaces.IOptioned;
import com.prs.abstraction.interfaces.ISubmitedCmdParser;

import java.util.ArrayList;
import java.util.List;

public class SubmittedObject implements ISubmitedCmdParser{

    private List<Option> _opts = new ArrayList<Option>();

    public SubmittedObject(Option option) {

        _opts.add(option);
    }

    @Override
    public IOptioned AddOption(String name, Class type, ConstraintTypes constraint) {
        return null;
    }

    @Override
    public IFlagged AddFlag(String name, ConstraintTypes constraint) {
        return null;
    }

    @Override
    public void parse(String[] args) {

    }
}

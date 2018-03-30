package com.prs.abstraction.interfaces;

import com.prs.abstraction.ConstraintTypes;

public interface ICmdParser extends IParse {

     IOptioned AddOption(String name, Class type, ConstraintTypes constraint);

     IFlagged AddFlag(String name, ConstraintTypes constraint);
}

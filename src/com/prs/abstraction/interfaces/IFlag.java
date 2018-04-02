package com.prs.abstraction.interfaces;

public interface IFlag extends IValued {

    /**
     *
     * @return the defined expression of a flag
     */
    public String get_expression();

    /**
     *
     * @return the meaningful name defined for the flag
     */
    public String get_meaningfulName();

}

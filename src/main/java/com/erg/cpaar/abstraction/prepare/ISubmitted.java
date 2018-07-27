package com.erg.cpaar.abstraction.prepare;

import com.erg.cpaar.abstraction.prepare.IParserStarter;

public interface ISubmitted  extends IParserStarter {

    public void parse(String[] args) throws Exception;
}

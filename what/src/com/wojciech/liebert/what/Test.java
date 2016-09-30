package com.wojciech.liebert.what;

/**
 * Created by shorti1996 on 13.06.2016.
 */
public class Test {
    public Test(){}

    public Elem kopia(Elem poc) {
        if (poc.nast == null) return poc;
        Elem kop = new Elem(poc);
        kop.nast = kopia(poc.nast);
        return kop;
    }
}

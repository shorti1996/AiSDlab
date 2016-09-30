package com.wojciech.liebert.lab10;

/**
 * Created by shorti1996 on 04.05.2016.
 */
public class DuplicateItemException extends RuntimeException {

    public DuplicateItemException(){
        super();
    }

    public DuplicateItemException(String s) {
        super(s);
    }
}


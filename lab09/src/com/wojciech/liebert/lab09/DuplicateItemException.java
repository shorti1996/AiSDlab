package com.wojciech.liebert.lab09;

/**
 * Created by shorti1996 on 26.04.2016.
 */
public class DuplicateItemException extends RuntimeException {

    public DuplicateItemException(){
        super();
    }

    public DuplicateItemException(String s) {
        super(s);
    }
}

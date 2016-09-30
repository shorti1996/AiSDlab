package com.wojciech.liebert.lab10_1;

/**
 * Created by shorti1996 on 04.05.2016.
 */
public class TwoFourNodeException extends RuntimeException {
    public TwoFourNodeException() {
        super ("Issues with TwoFourNode");
    }

    public TwoFourNodeException(String anErrorMsg) {
        super (anErrorMsg);
    }
}
package com.wojciechliebert.lab04;

/**
 * Created by shorti1996 on 16.03.2016.
 */
public class EmptyQueueException extends Throwable {
    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException() {
        super();
    }
}

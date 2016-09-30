package com.wojciechliebert.lab04;

/**
 * Created by shorti1996 on 09.03.2016.
 */
public class ValueIterator /*implements Iterator*/ {
    MyQueue _list;
    Element _current;

    public ValueIterator(MyQueue list){
        _list = list;
        _current = _list.first;
    }

    public void first()
    { _current = _list.first; }

    /*public void last()
    { _current = _list._head.getPrevious(); }*/

    public boolean isDone()
    { return _current == null; }

    public void next()
    { _current = _current.getNext(); }

    /*public void previous()
    { _current = _current.getPrevious(); }*/

    public Object current() throws IndexOutOfBoundsException {
        if (isDone())
                /*throw new IndexOutOfBoundsException()*/;
        return _current.getValue();
    }
}

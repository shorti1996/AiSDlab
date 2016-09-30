package com.wojciechliebert.lab03v2;

/**
 * Created by shorti1996 on 09.03.2016.
 */
public final class ValueIterator /*implements Iterator*/ {
    LinkedList _list;
    Element _current;

    public ValueIterator(LinkedList list){
        _list = list;
        _current = _list._head;
    }

    public void first()
    { _current = _list._head.getNext(); }

    public void last()
    { _current = _list._head.getPrevious(); }

    public boolean isDone()
    { return _current == _list._head; }

    public void next()
    { _current = _current.getNext(); }

    public void previous()
    { _current = _current.getPrevious(); }

    public Object current() throws IndexOutOfBoundsException {
        if (isDone())
                /*throw new IndexOutOfBoundsException()*/;
        return _current.getValue();
    }
}

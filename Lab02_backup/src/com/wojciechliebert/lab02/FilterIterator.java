package com.wojciechliebert.lab02;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Created by shorti1996 on 02.03.2016.
 */
public class FilterIterator
{   private final Iterator _it;
    private final Predicate _pred;

    public FilterIterator(Iterator it, Predicate pred)
    {  _it=it; _pred=pred; }

    public void filterForwards()
    { while( !_it.isDone() && !_pred.accept(_it.current()))
        _it.next();
    }

    public void filterBackwards()
    { while( !_it.isDone() && !_pred.accept(_it.current()))
        _it.previous();
    }

    public void first()
    { _it.first();
        filterForwards();}

    public void last()
    { _it.last();
        filterBackwards();}

    public void next()
    {_it.next();
        filterForwards();}

    public void previous()
    {_it.previous();
        filterBackwards();}

    public boolean isDone()
    {return _it.isDone(); }

    public Object current()
    { return _it.current();}
}

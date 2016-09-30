package com.wojciechliebert.lab02;

//import java.util.Iterator;
import com.wojciechliebert.lab02.ArrayIterator;
import com.wojciechliebert.lab02.PredZaliczyli;
import java.util.function.Predicate;

/**
 * Created by shorti1996 on 02.03.2016.
 */
public class FilterIterator
{   private final ArrayIterator _it;
    private final PredZaliczyli _pred;

    public FilterIterator(ArrayIterator it, PredZaliczyli pred)
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
    {
        return _it.isDone();
    }

    public boolean hasNext(){
        boolean hasIt = false;
        if(_it.isDone()){
            if(_it.current()==null){
                return false;
            }
            else return true;
            /*try{
                return _it.isDone();
            }
            catch (IndexOutOfBoundsException ex){
                return true;
            }*/
        }
        return hasIt;
    }

    public Object current()
    { return _it.current();}
}

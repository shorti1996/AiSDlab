package com.wojciechliebert.lab03;

/**
 * Created by shorti1996 on 09.03.2016.
 */
public class ArrayIterator// implements ArrayIterator
{
    Object[] _array;
    int _first;
    int _last;
    int _current=-1;

    public ArrayIterator()
    {
    }

    public ArrayIterator(Object[] array, int start, int length)
    {
        _array=array;
        _first=start;
        _last=start+length-1;
    }

    public ArrayIterator(Object[] array)
    {
        _array=array;
        _first=0;
        _last=array.length-1;
    }

    public void first()
    {
        _current=_first;
    }

    public void last()
    {
        _current=_last;
    }

    public void next()
    {
        ++_current;
        //return _array[_current];
    }


    public void previous()
    {
        --_current;
    }

    public boolean hasNext(){
        boolean doesIt = false;
        if (_current < _last){
            _current++;
            if (current() != null){
                doesIt = true;
                _current--;
            }
        }
        else
            doesIt = false;
        return doesIt;
    }

    public boolean isDone()
    {
        return _current <_first || _current> _last;
    }

    public Object current()
    {
        /*try
        {
            return _array[_current];
        }catch (ArrayIndexOutOfBoundsException ex){};
        return new Student();*/
        return _array[_current];
    }
}


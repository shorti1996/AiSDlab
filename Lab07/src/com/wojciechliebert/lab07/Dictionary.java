package com.wojciechliebert.lab07;

import com.sun.scenario.effect.Merge;

import java.util.Iterator;

/**
 * Created by shorti1996 on 13.04.2016.
 */
public class Dictionary {
    public Object[] _tab;
    public Object[] _pom;

    public Dictionary(){
        _tab = new Object[0];
        _pom = new Object[5];
    }

    public void sort(Object[] array){
        SelectSort ss = new SelectSort(new NaturalComparator());
        array = ss.sort(array);
    }

    public void wstaw(Object object){
        if (!isFull(_pom)){
            _pom[FirstEmpty(_pom)] = object;
        }
        else {
            sort(_pom);
            ScalTabPom();
            //_pom = new Object[_pom.length];
            wstaw(object);
        }
    }

    public int wyszukaj(Object object){
        int index = -1;
        if (!isEmpty(_pom)){
            sort(_pom);
            ScalTabPom();
        }
        index = wyszukajBinarnie(object);
        return index;
    }

    private int wyszukajBinarnie(Object object) {
        int index = -1;
        IterativeBinaryListSearcher searcher = new IterativeBinaryListSearcher(new NaturalComparator());
        index = searcher.search(_tab, object);
        return index;
    }

    public void ScalTabPom(){
        MergeSort ms = new MergeSort(new NaturalComparator());
        _tab = ms.merge(_tab, _pom);
        _pom = new Object[_pom.length];
    }

    public boolean isEmpty(Object[] array){
        boolean toReturn = false;
        for (int i = 0; i < array.length-1; i++){
            if (array[i] == null){
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }

    public boolean isFull(Object[] array){
        if (array[array.length-1] == null){
            return false;
        }
        else
            return true;
    }

    public int FirstEmpty(Object[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                return i;
            }
        }
        return -1;
    }

    public int size(){
        Object[] array = _tab;
        if (array[0] == null)
            return 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == null)
                return i;
        }
        return array.length;
    }
}

package com.wojciech.liebert.lab10_1;

/**
 * Created by shorti1996 on 04.05.2016.
 */
import java.util.Comparator;
//Included for needed comparator
class DefaultComparator<T> implements Comparator<T> {
    @SuppressWarnings("unchecked")
    public int compare(T a, T b) {
        return ((Comparable<T>)a).compareTo(b);
    }
}
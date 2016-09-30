package com.wojciechliebert.lab06;

/**
 * Created by shorti1996 on 05.04.2016.
 */
public class NaturalComparator implements Comparator {
    public NaturalComparator(){}
    public int compare(Object left, Object right){
        return ((Comparable)left).compareTo(right);
    }
}

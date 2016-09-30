package com.wojciechliebert.lab06;

/**
 * Created by shorti1996 on 05.04.2016.
 */
public class IntegerComparator implements Comparator {
    public IntegerComparator(){}
    public int compare(Object left, Object right){
        int result = ((Comparable)left).compareTo(right);
        return result;
    }
}

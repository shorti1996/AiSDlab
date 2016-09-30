package com.wojciech.liebert.lab10;

/**
 * Created by shorti1996 on 04.05.2016.
 */
public class NaturalComparator implements Comparator {
    public NaturalComparator(){}
    public int compare(Object left, Object right){
        if (left == null && right == null) return 0;
        if (left == null) return 1;
        if (right == null) return -1;
        return ((Comparable)left).compareTo(right);
    }
}


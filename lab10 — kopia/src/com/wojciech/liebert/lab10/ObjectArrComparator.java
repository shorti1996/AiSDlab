package com.wojciech.liebert.lab10;

/**
 * Created by shorti1996 on 04.05.2016.
 */
public class ObjectArrComparator {
    public ObjectArrComparator(){}
    public int compare(Object left, Object right){
        if (left == null && right == null) return 0;
        if (left == null) return 1;
        if (right == null) return -1;

        return ((Comparable)left).compareTo(right);
    }

    public int compare(Object[] array, Object obj){
        if (array == null && obj == null) return 0;
        if (array == null) return 1;
        if (obj == null) return -1;

        int toReturn = 0;
        int changed = 0;
        while (toReturn != 0){
            for (Object o : array){
                toReturn = ((Comparable)array[0]).compareTo(obj);
                if (toReturn == -toReturn){
                    changed = 1;
                    break;
                }
            }

        }
        if (changed == 1){
            return 0;
        }
        return toReturn;
    }
}

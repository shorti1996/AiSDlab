package com.wojciechliebert.lab06;

import java.util.List;

/**
 * Created by shorti1996 on 06.04.2016.
 */

public class InsertSort {
    private final Comparator _comparator;

    public InsertSort(Comparator comparator)  { _comparator = comparator; }

    public List sort(List list) {
        for (int i = 1; i < list.size(); ++i) {
            Object value = list.get(i),temp;
            int j;
            for (j = i; j > 0&& _comparator.compare(value, temp=list.get(j - 1))< 0; --j)
                list.set(j,temp);
            list.set(j, value);
        }
        return list;
    }

    public int[] sort(int[] list){
        for (int i = 1; i < list.length; ++i) {
            int value = list[i],temp;
            int j;
            for (j = i; j > 0&& _comparator.compare(value, temp=list[j - 1]) < 0; --j)
                list[j] = temp;
            list[j] = value;
        }
        return list;
    }

    public Object[] sort(Object[] list){
        for (int i = 1; i < list.length; ++i) {
            Object value = list[i],temp;
            int j;
            for (j = i; j > 0&& _comparator.compare(value, temp=list[j - 1]) < 0; --j)
                list[j] = temp;
            list[j] = value;
        }
        return list;
    }
}


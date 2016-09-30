package com.wojciechliebert.lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shorti1996 on 05.04.2016.
 */
public class MergeSort {
    private final Comparator _comparator;

    public MergeSort(Comparator comparator)  {  _comparator = comparator; }

    // wynikiem jest nowa lista
    public List sort(List list)
    { return mergesort(list, 0, list.size() - 1); }

    private List mergesort(List list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            List result = new ArrayList();
            result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex),
                mergesort(list, splitIndex + 1, endIndex));
    }

    private List merge(List left, List right) {
        List result = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < left.size() && j < right.size()){
            if (_comparator.compare(left.get(i), right.get(j)) <= 0){
                result.add(left.get(i));
                i++;
            }
            else {
                result.add(right.get(i));
                j++;
            }
        }
        while(i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while(j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}


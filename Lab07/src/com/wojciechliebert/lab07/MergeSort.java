package com.wojciechliebert.lab07;

/**
 * Created by shorti1996 on 13.04.2016.
 */
public class MergeSort{
    private final Comparator _comparator;

    public MergeSort(Comparator comparator)  {  _comparator = comparator; }

    // wynikiem jest nowa lista
    public Object[] sort(Object[] list)
    { return mergesort(list, 0, list.length - 1); }

    private Object[] mergesort(Object[] list, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            Object[] result = new Object[list.length];
            for (int i = 0; i < result.length-1; i++){
                if (result[i] == null){
                    result[i] = list[startIndex];
                }
            }
            //result.add(list.get(startIndex));
            return result;
        }
        int splitIndex = startIndex + (endIndex - startIndex) / 2;
        return merge(mergesort(list, startIndex, splitIndex),
                mergesort(list, splitIndex + 1, endIndex));
    }

    public Object[] merge(Object[] left, Object[] right) {
        Object[] result = new Object[left.length+right.length];
        //Iterator l = left.iterator();  Iterator r = right.iterator();
        //l.first(); r.first();
        int l = 0; int r = 0;
        while (l < left.length && r < right.length) {
            if (_comparator.compare(left[l], right[r]) <= 0)
            { result[FirstEmpty(result)] = left[l] ; l++; }
            else { result[FirstEmpty(result)] = right[r] ; r++; }
        }
        while(l < left.length)
        { result[FirstEmpty(result)] = left[l]; l++; }
        while(r < right.length)
        { result[FirstEmpty(result)] = right[r] ; r++; }
        return result;
    }

    public int FirstEmpty(Object[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == null){
                return i;
            }
        }
        return -1;
    }

}

package com.wojciechliebert.lab07;

/**
 * Created by shorti1996 on 13.04.2016.
 */
public class SelectSort {
    private final Comparator _comparator;

    public SelectSort(Comparator comparator)  { _comparator = comparator; }

    public Object[] sort(Object[] list) {
        int size = list.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check)
                if (_comparator.compare(list[check], list[smallest]) < 0)
                    smallest = check;
            swap(list, smallest, slot);
        }
        return list;
    }

    private void swap(Object[] list, int left, int right) {
        if (left != right) { // podejście optymisty
            Object temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }
}

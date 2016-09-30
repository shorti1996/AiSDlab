package com.wojciechliebert.lab06;

import java.util.List;

/**
 * Created by shorti1996 on 05.04.2016.
 */

public class SelectSort {
    private final Comparator _comparator;

    public SelectSort(Comparator comparator)  { _comparator = comparator; }

    public List sort(List list) {
        int size = list.size();
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot;
            for (int check = slot + 1; check < size; ++check)
                if (_comparator.compare(list.get(check), list.get(smallest)) < 0)
                    smallest = check;
            swap(list, smallest, slot);
        }
        return list;
    }
    private void swap(List list, int left, int right) {
        if (left != right) { // podejście optymisty
            Object temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }
}

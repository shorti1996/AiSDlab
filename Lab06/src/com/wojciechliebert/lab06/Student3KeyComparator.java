package com.wojciechliebert.lab06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shorti1996 on 06.04.2016.
 */
public class Student3KeyComparator implements Comparator {
        //tablica komparatorów ; od najważniejszego
        private final List _comparators = new ArrayList();

        public void addComparator(Comparator comparator)
        { _comparators.add(comparator); }

        public int compare(Object left, Object right) throws ClassCastException {
            int result = 0;
            int i = 0;
            for (i = 0; i < _comparators.size() &&
                    (result = ((Comparator) _comparators.get(i)).compare(left, right))==0; i++);
            return result;
        }

}

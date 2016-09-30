package com.wojciechliebert.lab06;

/**
 * Created by shorti1996 on 06.04.2016.
 */
public class StudentComplexComparator implements Comparator {
    /*for (i = 0; i < _comparators.size() &&
            (result = ((Comparator) _comparators.get(i)).compare(left, right))==0; i++);*/
    public StudentComplexComparator(){}

    public int compare(Object left, Object right){
        int result = 0;
        Student studentLeft = (Student)left;
        Student studentRight = (Student)right;
        result = ((Comparable)studentLeft.nazwisko).compareTo(studentRight.nazwisko);
        if (result == 0){
            result = ((Comparable)studentLeft.imie).compareTo(studentRight.imie);
            if (result == 0){
                result = ((Comparable)studentLeft.indeks).compareTo(studentRight.indeks);
            }
        }
        return result;
    }
}

package com.wojciechliebert.lab06;

/**
 * Created by shorti1996 on 06.04.2016.
 */
public class StudentIndexComparator implements Comparator {
    public StudentIndexComparator(){}
    public int compare(Object left, Object right){
        Student studentLeft = (Student)left;
        Student studentRight = (Student)right;
        return ((Comparable)studentLeft.indeks).compareTo(studentRight.indeks);
    }
}

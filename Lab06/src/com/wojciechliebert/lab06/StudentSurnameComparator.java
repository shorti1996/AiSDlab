package com.wojciechliebert.lab06;

/**
 * Created by shorti1996 on 06.04.2016.
 */
public class StudentSurnameComparator implements Comparator {
    public StudentSurnameComparator(){}
    public int compare(Object left, Object right){
        Student studentLeft = (Student)left;
        Student studentRight = (Student)right;
        return ((Comparable)studentLeft.nazwisko).compareTo(studentRight.nazwisko);
    }
}
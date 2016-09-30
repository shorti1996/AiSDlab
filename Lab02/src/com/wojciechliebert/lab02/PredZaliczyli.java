package com.wojciechliebert.lab02;

import java.util.function.Predicate;

/**
 * Created by shorti1996 on 02.03.2016.
 */
public class PredZaliczyli {
    public boolean accept(Student s) {
        boolean accept = false;
        if (s.ocena >= 3)
            accept = true;
        return accept;
    }
    public boolean accept(Object o) {
        if (o == null) return false;
        Student s = (Student)o;
        boolean accept = false;
        if (s.ocena >= 3)
            accept = true;
        return accept;
    }
}

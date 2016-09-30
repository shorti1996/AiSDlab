package com.wojciechliebert.lab02;

/**
 * Created by shorti1996 on 04.03.2016.
 */
public class PredNieZaliczyli {
    public boolean accept(Student s) {
        boolean accept = false;
        if (s.ocena < 3)
            accept = true;
        return accept;
    }
    public boolean accept(Object o) {
        if (o == null) return false;
        Student s = (Student)o;
        boolean accept = false;
        if (s.ocena < 3)
            accept = true;
        return accept;
    }
}

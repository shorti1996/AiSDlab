package com.wojciech.liebert.what;

public class Main {

    public static void main(String[] args) {
        Elem e1 = new Elem(1);
        Elem e2 = new Elem(2);
        Elem e3 = new Elem(3);
        Elem e4 = new Elem(4);
        e1.nast = e2;
        e2.nast = e3;
        e3.nast = e4;

        Test test = new Test();
        Elem k = new Elem(1);
        k = test.kopia(e1);
    }
}
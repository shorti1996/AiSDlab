package com.wojciechliebert.lab04_2;

/**
 * Created by shorti1996 on 21.03.2016.
 */
public class Liczba {
    public int liczba = -1;

    public Liczba(int l){
        liczba = l;
    }

    @Override
    public String toString(){
        return "" + liczba;
    }
}
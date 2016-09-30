package com.wojciech.liebert.what;

/**
 * Created by shorti1996 on 13.06.2016.
 */
public class Elem {
    public int val;
    public Elem nast;
    public Elem(int v){
        val = v;
    }
    public Elem(Elem e){
        val = e.val;
    }

}

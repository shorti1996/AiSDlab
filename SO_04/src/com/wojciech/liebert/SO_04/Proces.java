package com.wojciech.liebert.SO_04;

import java.util.ArrayList;

/**
 * Created by shorti1996 on 03.06.2016.
 */
public class Proces {
    int liczbaStron;
    ArrayList<Integer> odw;
    int bitPom;
    int bitPom2;
    public Proces(int liczbaStron, ArrayList<Integer> odw, int bitPom, int bitPom2)
    {
        this.liczbaStron=liczbaStron;
        this.odw=odw;
        this.bitPom=bitPom;
        this.bitPom2=bitPom2;
    }
    public int get(int i)
    {
        return odw.get(i);
    }
}

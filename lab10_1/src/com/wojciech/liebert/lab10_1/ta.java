package com.wojciech.liebert.lab10_1;

/**
 * Created by shorti1996 on 04.05.2016.
 */
public class ta implements Comparable<ta> {

    public int data;
    public ta(int d) {
        data = d;
    }


    public int compareTo(ta o) {
        int oabd = ((ta) o).data;
        //If one is bigger than the other
        return data - oabd;
    }
    public String toString() {
        // TODO Auto-generated method stub
        return "" + data;
    }

}

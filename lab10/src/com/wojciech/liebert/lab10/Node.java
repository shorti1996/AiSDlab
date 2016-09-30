package com.wojciech.liebert.lab10;

/**
 * Created by shorti1996 on 04.05.2016.
 */

public class Node{
    Object[] value = new Object[3];
    Object[] children = new Object[4];
    Node left;
    Node right;
    boolean visited = false;

    Node(Object x){
        value[0] = x;
        //left = right = null;
    }

    Node(Node n){
        value = n.value;
        left = n.left;
        right = n.right;
        //parent = n.parent;
        visited = n.visited;
    }

    @Override
    public String toString(){
        String toReturn = this.value[0] + ", " + this.value[1] + ", " +this.value[2];
        return toReturn;
    }

    public void setValue(int index, Object val){
        value[index] = val;
    }

    public void setValue(Object val){

    }

    public Object getValue(int index){
        return value[index];
    }

    public Object getValue(){
        return value;
    }

}

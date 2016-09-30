package com.wojciech.liebert.lab09;

/**
 * Created by shorti1996 on 26.04.2016.
 */
public class Node{
    Object value;
    Node left;
    Node right;
    boolean visited = false;
    boolean black = false;
    //BinarySearchTree BST = new BinarySearchTree(new NaturalComparator());
    public int height, nodesCount, nodesWithTwoChildrenCount, nodesWithOneChildrenCount;

    Node(){
    }

    Node(Object x){
        //super();
        value = x;
        left = right = /*parent = */null;
    }

    Node(Node n){
        value = n.value;
        left = n.left;
        right = n.right;
        visited = n.visited;
    }

    @Override
    public String toString(){
        return value.toString();
    }

    public Object getValue(){
        return value;
    }

    public boolean isBlack(){
        if (black)
            return true;
        else
            return false;
    }

    public String getColor(){
        if (black)
            return "black";
        else
            return "red";
    }

    public void setBlack(boolean black){
        if (black)
            this.black = true;
        else
            this.black = false;
    }

    public void setOppositeColor(){
        this.black = !this.black;
    }
}

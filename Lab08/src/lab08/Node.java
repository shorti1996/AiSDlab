package lab08;

import java.util.Objects;

/**
 * Created by shorti1996 on 19.04.2016.
 */
public class Node{
    Object value;
    Node left;
    Node right;
    //Node parent;
    boolean visited = false;

    Node(Object x){
        value = x;
        left = right = /*parent = */null;
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
        return value.toString();
    }

    public Object getValue(){
        return value;
    }

    /*public void setParent(Node node){
        parent = node;
    }*/
}

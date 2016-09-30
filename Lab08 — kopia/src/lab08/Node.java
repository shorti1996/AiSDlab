package lab08;

import java.util.Objects;

/**
 * Created by shorti1996 on 19.04.2016.
 */
public class Node implements Comparable<Node>{
    Object value;
    Node left;
    Node right;
    //Node parent;
    boolean visited = false;
    public int lic = 0;

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

    @Override
    public int compareTo(Node o) {
        int me = (int)this.value;
        int oVal = (int)o.value;
        return ((Comparable)me).compareTo(oVal);
    }



    /*public void setParent(Node node){
        parent = node;
    }*/
}

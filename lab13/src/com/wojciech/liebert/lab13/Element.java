package com.wojciech.liebert.lab13;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shorti1996 on 25.05.2016.
 */
public class Element {
    public int value;
    public Element parent;
    public List<Element> children = new LinkedList<>();
    public List<Edge> jointEdges = new LinkedList<>();
    private int rank = 0;
    public boolean visited = false;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Element(int v){
        value = v;
    }

    public Element(int v, Element p){
        value = v;
        parent = p;
    }

    public Element FindRepresentative(Element e){
        if (e.parent != null){
            return FindRepresentative(e.parent);
        }
        if (e.parent == null){
            return e;
        }
        return null;
    }

    @Override
    public String toString(){
        String toReturn = "";
        toReturn += value;
        return toReturn;
    }

}

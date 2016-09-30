package com.wojciech.liebert.lab13;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shorti1996 on 25.05.2016.
 */
public class Edge implements Comparable {
    List<Element> jointElements = new LinkedList<>();
    List<Integer> jointInts = new LinkedList<>();
    public int weight;

    public Edge(){}

    public Edge(int w){
        this();
        weight = w;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge)o;
        return Integer.compare(this.weight, e.weight);
    }
}

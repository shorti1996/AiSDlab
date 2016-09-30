package com.wojciech.liebert.lab12;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shorti1996 on 18.05.2016.
 */
public class DisjointSet {
    public List<Element> elements = new LinkedList<>();
    public Element representative;
    public DisjointSet previous;

    public DisjointSet(){}

    public DisjointSet(Element e){
        if (elements.size() == 0){
            representative = e;
        }
        elements.add(e);
    }

    public void AddElement(Element e){
        if (e.parent == null && elements.size() > 0){
            e.parent = elements.get(elements.size()-1);
        }
        elements.add(e);
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
        for (Element e :
                elements) {
            toReturn += e.value + ", ";
        }
        return toReturn;
    }
}

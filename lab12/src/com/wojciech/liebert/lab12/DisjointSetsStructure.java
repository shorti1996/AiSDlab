package com.wojciech.liebert.lab12;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shorti1996 on 18.05.2016.
 */
public class DisjointSetsStructure {
    List<DisjointSet> sets = new LinkedList<>();

    public DisjointSetsStructure(){
    }

    public void AddSet(DisjointSet ds){
        sets.add(ds);
    }

    /*public Element FindRepresentative(Element e){
        for (DisjointSet ds :
                sets) {
            for (int i = ds.elements.size()-1; i > 0; i--){
                if (ds.elements.get(i) == e){
                    return ds.representative;
                }
            }
        }
        return null;
    }*/

    public DisjointSet FindSet(Element e){
        for (DisjointSet ds :
                sets){
            for (int i = ds.elements.size()-1; i > 0; i--){
                if (ds.elements.get(i) == e){
                    return ds;
                }
            }
        }
        return null;
    }

    public Element FindRepresentative(Element e){
        DisjointSet ds1 = FindSet(e);

        if (e.parent != null){
            return ds1.FindRepresentative(e.parent);
        }
        if (e.parent == null && ds1.previous == null){
            return e;
        }
        if (ds1.previous != null){
            Element e2 = ds1.previous.elements.get(0);
            return FindRepresentative(e);
        }
        return null;
    }

    public void Union(Element e1, Element e2){
        DisjointSet d1 = FindSet(e1);
        DisjointSet d2 = FindSet(e2);
        d2.previous = d1;
    }

    public String toString(){
        String toReturn = "";
        for (int i = sets.size()-1; i >= 0; i--){
            DisjointSet ds = sets.get(i);
            toReturn += ds.toString();
            if (ds.previous != null)
                toReturn += " ^ ";
            else {
                toReturn += " /// ";
            }
        }
        return toReturn;
    }
}

package com.wojciech.liebert.lab12;

public class Main {

    public static void main(String[] args) {
        Element e1 = new Element(1);
        DisjointSet ds = new DisjointSet(e1);
        DisjointSetsStructure dss = new DisjointSetsStructure();
        dss.AddSet(ds);

        Element e2 = new Element(2);
        ds.AddElement(e2);
        Element e3 = new Element(3);
        ds.AddElement(e3);
        Element e4 = new Element(4);
        ds.AddElement(e4);

        System.out.println(ds.FindRepresentative(e4));

        Element e5 = new Element(5);
        Element e6 = new Element(6);
        DisjointSet ds2 = new DisjointSet(e5);
        ds2.AddElement(e6);

        dss.AddSet(ds2);

        Element e7 = new Element(7);
        Element e8 = new Element(8);
        DisjointSet ds3 = new DisjointSet(e7);
        ds3.AddElement(e8);
        dss.AddSet(ds3);

        Element e9 = new Element(9);
        DisjointSet ds4 = new DisjointSet(e9);
        ds4.AddElement(e9);
        dss.AddSet(ds4);

        Tree
        System.out.println(ds);
        System.out.println(ds2);

        dss.Union(e2, e6);
        System.out.println(dss.toString());

        dss.Union(e2, e8);
        System.out.println(dss.toString());
    }
}

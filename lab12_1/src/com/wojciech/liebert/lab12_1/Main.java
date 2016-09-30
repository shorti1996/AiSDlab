package com.wojciech.liebert.lab12_1;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DisjointSet ds1 = new DisjointSet();
        Element e1 = new Element(1);
        Element e2 = new Element(2);
        Element e3 = new Element(3);
        ds1.AddElement(e1);
        ds1.AddElement(e2);
        ds1.AddElement(e3);
        System.out.println("Reprezentant e1: " + ds1.FindRepresentative(e1));
        System.out.println("Reprezentant e2: " + ds1.FindRepresentative(e2));
        System.out.println("Reprezentant e3: " + ds1.FindRepresentative(e3));

        System.out.println("ds1: " + ds1.toString());

        DisjointSet ds2 = new DisjointSet();
        Element e4 = new Element(4);
        Element e5 = new Element(5);
        ds2.AddElement(e4);
        ds2.AddElement(e5);

        DisjointSet ds3 = new DisjointSet();
        Element e6 = new Element(6);
        Element e7 = new Element(7);
        Element e8 = new Element(8);
        ds3.AddElement(e6);
        ds3.AddElement(e7);
        //ds3.AddElement(e8);

        System.out.println("ds2: " + ds2.toString());
        ds1.Union(e4, e1);
        System.out.println("ds2 + ds1: " + ds2.toString());

        System.out.println("ds3: " + ds3.toString());
        ds1.Union(e6, e1);
        System.out.println("ds3 + ds1: " + ds3.toString());

        //List<Element> list1 = new LinkedList<>();
        //list1 = ds2.GetChildren(ds1.representative);
        List<Element> list2 = new LinkedList<>();
        list2 = ds1.preorder(ds1.representative, list2);
        System.out.println(list2);

        System.out.println(ds1.bfs());
        System.out.println("Level order ds1: ");
        ds1.DFS(ds1.representative);
        System.out.println("Level order ds2: ");
        ds1.DFS(ds3.representative);

        System.out.println("Kompresja ścieżki dla e7: ");
        ds1.CompressionFind(e7);
        ds1.DFS(ds1.representative);
    }
}

package com.wojciech.liebert.lab13;

public class Main {

    public static void main(String[] args) {
        Element e1 = new Element(1);
        Element e2 = new Element(2);
        Element e3 = new Element(3);
        Element e4 = new Element(4);
        DisjointSet ds1 = new DisjointSet();

        ds1.AddElement(e1);
        ds1.AddElement(e2);
        ds1.AddElement(e3);
        ds1.AddElement(e4);

        ds1.adjacencyMatrix.addEdge(1,2);
        //ds1.adjacencyMatrix.addEdge(2,1);
        ds1.adjacencyMatrix.addEdge(1,3);
        //ds1.adjacencyMatrix.addEdge(3,1);
        ds1.adjacencyMatrix.addEdge(3,4);
        //ds1.adjacencyMatrix.addEdge(4,3);

        ds1.UpdateEdges();
        ds1.edges.get(0).weight = 10; //1,2
        ds1.edges.get(1).weight = 20; //1,3
        ds1.edges.get(2).weight = 20; //3,4



    }
}

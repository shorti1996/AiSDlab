package com.wojciech.liebert.lab13;

/**
 * Created by shorti1996 on 25.05.2016.
 */
public class AdjacencyMatrix {
    int n;
    public boolean[][] a;
    AdjacencyMatrix(int n0) {
        n = n0;
        a = new boolean[n][n];
    }

    void addEdge(int i, int j) {
        a[i][j] = true;
    }
    void removeEdge(int i, int j) {
        a[i][j] = false;
    }
    boolean hasEdge(int i, int j) {
        return a[i][j];
    }
}

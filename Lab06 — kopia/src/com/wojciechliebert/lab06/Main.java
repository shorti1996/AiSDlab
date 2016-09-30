package com.wojciechliebert.lab06;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] tab = {9, 8, 7, 1, 2, 3, 6, 5, 4};
        List lista = new ArrayList<Integer>();
        for (int i : tab){
            lista.add(i);
        }
        System.out.println("lista:");
        for (int i : tab){
            System.out.println(i);
        }
        System.out.println("\n***************\n");

        SelectSort selectSort = new SelectSort(new NaturalComparator());
        List sortedSelect = selectSort.sort(lista);
        System.out.println("select sort:");
        for (Object i : sortedSelect){
            System.out.println(i);
        }
        System.out.println("\n***************\n");

        MergeSort mergeSort = new MergeSort(new NaturalComparator());
        List sortedMerge = mergeSort.sort(lista);
        System.out.println("merge sort:");
        for (Object i : sortedMerge){
            System.out.println(i);
        }
        System.out.println("\n***************\n");
    }
}

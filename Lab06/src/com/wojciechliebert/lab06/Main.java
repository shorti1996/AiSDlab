package com.wojciechliebert.lab06;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*int[] tab = {9, 8, 7, 1, 2, 3, 6, 5, 4};
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

        InsertSort insertSort = new InsertSort(new NaturalComparator());
        int[] sortedInsert = new int[10];
        /*for (int i = 0; i < tab.length; i++){
            sortedInsert =
        }*/
        /*sortedInsert = insertSort.sort(tab);
        System.out.println("insert sort:");
        for (Object i : sortedInsert){
            System.out.println(i);
        }
        System.out.println("\n***************\n");*/

        Object[] tablicaStudentow = {
                new Student(123456, "aaa", "ddd", 1.0),
                new Student(954321, "aaa", "bbb", 2.0),
                new Student(687654, "aaa", "aaa", 3.0),
                new Student(874521, "ggg", "hhh", 4.0),
                new Student(321456, "iii", "jjj", 5.0)
        };

        //INSERT SORT
        InsertSort insertSort1 = new InsertSort(new StudentIndexComparator());
        Object[] sortedInsert1 = new Object[tablicaStudentow.length];
        sortedInsert1 = insertSort1.sort(tablicaStudentow);
        System.out.println("insert sort:");
        for (Object i : sortedInsert1){
            System.out.println(i);
        }

        //QUICK SORT
        QuickSort quickSort = new QuickSort(new StudentIndexComparator());
        Object[] sortedQuick = new Object[tablicaStudentow.length];
        sortedQuick = quickSort.sort(tablicaStudentow);
        System.out.println("\nquick sort:");
        for (Object i : sortedQuick){
            System.out.println(i);
        }

        //INSERT SORT 3 KEYS
        Student3KeyComparator student3KeyComparator = new Student3KeyComparator();
        student3KeyComparator.addComparator(new StudentSurnameComparator());
        student3KeyComparator.addComparator(new StudentNameComparator());
        student3KeyComparator.addComparator(new StudentIndexComparator());
        InsertSort insertSort2 = new InsertSort(student3KeyComparator);
        Object[] sortedInsert2 = new Object[tablicaStudentow.length];
        sortedInsert2 = insertSort2.sort(tablicaStudentow);
        System.out.println("\ninsert sort 3 keys:");
        for (Object i : sortedInsert2){
            System.out.println(i);
        }

        //QUICK SORT ComplexComparator
        QuickSort quickSort1 = new QuickSort(new StudentComplexComparator());
        Object[] sortedQuick1 = new Object[tablicaStudentow.length];
        sortedQuick1 = quickSort1.sort(tablicaStudentow);
        System.out.println("\nquick sort complex comparator:");
        for (Object i : sortedQuick1){
            System.out.println(i);
        }
    }
}

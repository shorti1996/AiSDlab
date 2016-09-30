package com.wojciech.liebert.lab14;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PriorityQ<Integer> pq = new PriorityQ();
        pq.insert(5);
        pq.insert(4);
        pq.insert(3);
        pq.insert(2);
        pq.insert(1);
        pq.insert(9);
        System.out.printf("%20s%s%n", "Kolejka: ", pq.toString());
        pq.deleteAt(3);
        System.out.printf("%20s%s%n", "deleteAt(3): ", pq.toString());
        pq.changePriority(2, 0);
        System.out.printf("%20s%s%n", "pq 2=>0: ", pq.toString());

        Integer[] tabToSort = new Integer[10];
        for (int i = tabToSort.length-1; i >= 0; i--){
            tabToSort[i] = tabToSort.length-i;
        }

        PriorityQ<Integer> pq1 = new PriorityQ(tabToSort);
        List<Integer> sorted = new LinkedList<>();
        sorted = pq1.MakeList();
        System.out.printf("%n%20s%s%n", "Kolejka 10-1: ", sorted.toString());
    }
}

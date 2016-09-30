package com.wojciech.liebert.lab09;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree(new NaturalComparator());
        /*binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);*/
        /*binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(25);
        binarySearchTree.insert(40);
        binarySearchTree.insert(50);
        binarySearchTree.insert(24);
        binarySearchTree.insert(26);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);*/
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(15);
        binarySearchTree.insert(18);
        binarySearchTree.insert(25);
        binarySearchTree.insert(16);
        binarySearchTree.insert(12);
        //binarySearchTree.insert(19);

        System.out.println("BFS:");
        binarySearchTree.bfs();

        System.out.println("Szukaj \"25\":");
        System.out.println(binarySearchTree.find(25));
        System.out.println("Szukaj \"99\":");
        System.out.println(binarySearchTree.find(99));

        System.out.println("Wysokosc drzewa: " + binarySearchTree.findHeight());
        System.out.println("Liczba wezlow: " + binarySearchTree.findLeavesCount());

        /*System.out.println("Liczba wezlow z dwoma potomkami: " + binarySearchTree.NodesWithTwoChildrenCount(binarySearchTree.root()));
        System.out.println("Liczba wezlow z dwoma potomkami od 20: " + binarySearchTree.NodesWithTwoChildrenCount(binarySearchTree.search(20)));
        System.out.println("Liczba wezlow z dwoma potomkami od 10: " + binarySearchTree.NodesWithTwoChildrenCount(binarySearchTree.search(10)));
        System.out.println("Liczba wezlow z jedym potomkiem: " + binarySearchTree.NodesWithOneChildrenCount(binarySearchTree.root()));
        System.out.println("Liczba wezlow z jedym potomkiem od 20: " + binarySearchTree.NodesWithOneChildrenCount(binarySearchTree.search(20)));
        */
        binarySearchTree.UpdateNodesProperties();
        System.out.println("Liczba wezlow od 20: " + binarySearchTree.search(20).nodesCount);
        System.out.println("Liczba wezlow z dwoma potomkami od 20: " + binarySearchTree.search(20).nodesWithTwoChildrenCount);
        System.out.println("Liczba wezlow z jedym potomkiem od 20: " + binarySearchTree.search(20).nodesWithOneChildrenCount);
        System.out.println("Wysokosc drzewa od 20: " + binarySearchTree.search(20).height);

        binarySearchTree.height(binarySearchTree.search(20));
    }
}

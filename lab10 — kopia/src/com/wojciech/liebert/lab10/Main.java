package com.wojciech.liebert.lab10;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(new NaturalComparator());
        Node n1 = new Node(1);
        bst.insert(n1);
        bst.insert(new Node(2));
        bst.insert(new Node(3));
        bst.insert(new Node(4));
        bst.insert(new Node(5));
        bst.insert(new Node(6));

        bst.JedenPotomek(n1);
    }
}

package com.wojciech.liebert.lab11;

public class Main {

    public static void main(String[] args) {
        HashTable ht = new HashTable(17);
        ht.Insert(87, 2);
        ht.Insert(1, 55);
        ht.Insert(4, 55);
        ht.Insert(6, 123);
        ht.Insert(8, 707);
        ht.Insert(44, 9887);
        ht.Insert(88, 14);
        ht.Insert(90, 556);
        ht.Insert(78, 465);
        ht.Insert(741, 54222);
        ht.Insert(73, 51233);
        ht.Insert(111, 232);
        ht.Insert(881, 1222);
        ht.Insert(21, 5222215);

        System.out.println(ht.GetObject(87));
        System.out.println(ht.GetObject(1));
        System.out.println(ht.GetObject(88));

        System.out.println("Czy zawiera 87: " + ht.CzyZawiera(87));
        System.out.println("Czy zawiera 99: " + ht.CzyZawiera(99));

        System.out.println("Dump: " + ht.Dump());
    }
}

package com.wojciech.liebert.lab10_1;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        TwoFourTree tft = new TwoFourTree();
        tft.add(new ta(20));
        tft.add(new ta(10));
        tft.add(new ta(15));
        tft.add(new ta(18));
        tft.add(new ta(25));
        tft.add(new ta(16));
        tft.add(new ta(12));

        System.out.println(tft.toString());

        System.out.println(tft.find(new ta(18)));
        System.out.println(tft.find(new ta(99)));

        System.out.println(tft.findNodeLargest(tft.getRoot()).largestElem());
        System.out.println(tft.findNodeSmallest(tft.getRoot()).smallestElem());

        tft.remove(new ta(15));
        tft.remove(new ta(20));
        System.out.println(tft.toString());
    }

}

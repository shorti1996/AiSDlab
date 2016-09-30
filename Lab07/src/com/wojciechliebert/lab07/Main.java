package com.wojciechliebert.lab07;

public class Main {

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        for (int i = 9; i > 0; i--){
            dict.wstaw(i);
        }

        System.out.println("Szukany /6/ jest na miejscu " + dict.wyszukaj(6));
        System.out.println("Szukany /2/ jest na miejscu " + dict.wyszukaj(2));
        System.out.println("Szukany /11/ jest na miejscu " + dict.wyszukaj(11));

        for (int i = 0; i < dict.size(); i++){
            System.out.println(dict._tab[i]);
            //System.out.println(array[i]);
        }

        /*MergeSort ms = new MergeSort(new NaturalComparator());
        Object[] array = new Object[10];
        for (int i = array.length-1; i > 0; i--){
            array[i] = i;
        }
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
        ms.sort(array);*/
    }
}

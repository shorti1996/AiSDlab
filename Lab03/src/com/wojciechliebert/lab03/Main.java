package com.wojciechliebert.lab03;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        List lista = new LinkedList();

        lista.add(new Student(123456, "aaa", "bbb", 3.0));
        Iterator it= lista.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("Koniec");


    }

    public void wydruki()
    { //wypełnienie elementów listy

    }
}

package com.wojciechliebert.lab04;

public class Main {

    public static void main(String[] args) {

        //tworzenie kolejki
        MyQueue queue = new MyQueue();
        //dodanie obiektów
        queue.enqueue(new Liczba(0));
        queue.enqueue(new Liczba(1));
        queue.enqueue(new Liczba(2));
        queue.enqueue(new Liczba(3));
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(new Liczba(4));
        //tworzenie iteratora
        ValueIterator it = new ValueIterator(queue);
        //listowanie
        it.first();
        it.next();
        while(!it.isDone())
        {
            System.out.println(it.current());
            it.next();
        }
        System.out.println("Koniec");

        /*
        //tworzenie listy
        LinkedList lista = new LinkedList();
        //dodanie obiektów
        lista.add(new Liczba(0));
        lista.add(new Liczba(1));
        lista.add(new Liczba(2));
        //tworzenie iteratora
        ValueIterator it = lista.iterator();
        //listowanie
        it.first();
        it.next();
        while(!it.isDone())
        {
            System.out.println(it.current());
            it.next();
        }
        System.out.println("Koniec");

        //enqueue
        ListFifoQueue kolejka = new ListFifoQueue(lista);
        kolejka.enqueue(new Liczba(3));
        kolejka.enqueue(new Liczba(4));

        //listowanie
        it.first();
        it.next();
        while(!it.isDone())
        {
            System.out.println(it.current());
            it.next();
        }
        System.out.println("Koniec");*/

    }
}

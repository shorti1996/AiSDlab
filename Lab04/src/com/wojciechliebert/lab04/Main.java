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

    }
}

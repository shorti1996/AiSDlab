package com.wojciechliebert.lab04_2;

public class Main {

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue();
        try {
            aq.enqueue(new Liczba(0));
            aq.enqueue(new Liczba(1));
            aq.enqueue(new Liczba(2));
            aq.enqueue(new Liczba(3));
            aq.enqueue(new Liczba(4));
            aq.enqueue(new Liczba(5));
        }
        catch (Queue.QueueFullException ex){
            System.out.println("ERROR while enqueuing: " + ex.getMessage());
        }
        //aq.enqueue(new Liczba(7));
        aq.list();

        System.out.print("KONIEC\n\n");
        aq.dequeue();
        aq.dequeue();
        aq.list();

        System.out.print("KONIEC\n\n");
        aq.enqueue(new Liczba(99));
        aq.dequeue();
        aq.enqueue(new Liczba(123));
        aq.list();

    }
}

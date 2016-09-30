package com.wojciechliebert.lab04;

public interface Queue {

    public void enqueue(Object value); //wstaw do kolejki
    public Object dequeue() throws EmptyQueueException; //pobierz z kolejki
    public void clear(); //usuń wszystkie elementy
    public int size();  //długość kolejki
    public boolean isEmpty(); // true jeśli kolejka jest pusta
}
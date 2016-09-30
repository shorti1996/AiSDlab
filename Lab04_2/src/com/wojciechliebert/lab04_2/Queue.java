package com.wojciechliebert.lab04_2;

/**
 * Created by shorti1996 on 21.03.2016.
 */
public interface Queue {

    public void enqueue(Object value) throws QueueFullException; //wstaw do kolejki
    public Object dequeue() throws EmptyQueueException; //pobierz z kolejki
    public void clear(); //usuń wszystkie elementy
    public int size();  //długość kolejki
    public boolean isEmpty(); // true jeśli kolejka jest pusta

    class EmptyQueueException extends RuntimeException {
        public EmptyQueueException(){
            super();
        }
        public EmptyQueueException(String message){
            super(message);
        }
    }

    class QueueFullException extends RuntimeException {
        public QueueFullException(){
            super();
        }
        public QueueFullException(String message){
            super(message);
        }
    }
}

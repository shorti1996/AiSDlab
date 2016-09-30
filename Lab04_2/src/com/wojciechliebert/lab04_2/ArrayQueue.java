package com.wojciechliebert.lab04_2;

/**
 * Created by shorti1996 on 21.03.2016.
 */
public class ArrayQueue implements Queue{
    public Object[] _array;
    public int _size;

    public ArrayQueue(){
        clear();
    }

    public ArrayQueue(int size){
        _array = new Object[size];
        _size = 0;
    }

    //wstaw do kolejki
    public void enqueue(Object value) throws QueueFullException{
        for (int i = 0; i < _array.length; i++){
            if (_array[i] == null){
                _array[i] = value;
                _size++;
                return;
            }
        }
        throw  new QueueFullException("Cannot enqueue a new Object because the queue is already full.");
    }

    //pobierz z kolejki
    public Object dequeue() throws EmptyQueueException{
        Object value = new Object();
        value = _array[0];
        for (int i = 0; i < _array.length-1; i++){
            _array[i] = _array[i+1];
        }
        _array[_array.length-1] = null;
        _size--;
        return value;
    }

    //usuń wszystkie elementy
    public void clear(){
        _array = new Object[5];
        _size = 0;
    }

    //długość kolejki
    public int size(){
        return _size;
    }

    //true jeśli kolejka jest pusta
    public boolean isEmpty(){
        boolean isEmpty;
        if (_array[0] == null) isEmpty = true;
        else isEmpty = false;
        return isEmpty;
    }

    //kontrolne wyświetlenie elementów kolejki
    public void list(){
        for (int i = 0; i < _size; i++){
            System.out.println(_array[i]);
        }
    }

}

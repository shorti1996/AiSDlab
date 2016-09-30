package com.wojciechliebert.lab05;

/**
 * Created by shorti1996 on 30.03.2016.
 */
public class MyStack implements Stack{

    public Element first = null; // puste miejsce do wykorzystania
    public int _size;    // dlugość listy

    public MyStack(){
        clear();
    }

    public MyStack(int size){
        _size = size;
        clear();
    }

    //czyść stos
    public void clear() {
        first = null;
        _size = 0;
    }

    // wysokość stosu
    public int size(){
        return _size;
    }

    //true jeśli stos jest pusty
    public boolean isEmpty(){
        if (size() == 0) return true;
        else return false;
    }

    // odłóż na stos
    public void push(Object value){
        Element element1 = first;
        Element element2 = new Element(value);
        element2.setNext(first);
        first = element2;
        _size++;
    }

    //pobierz ze stosu
    public Object pop(){
        Element element1 = first;
        Element element2 = first.getNext();
        Element elementToReturn = new Element(element1.getValue());

        first = element2;
        --_size;
        return elementToReturn.getValue();
    }

    //odczytaj ( nieniszcząco ) ze stosu
    public Object peek(){
        return first.getValue();
    }

}

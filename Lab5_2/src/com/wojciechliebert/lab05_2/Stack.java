package com.wojciechliebert.lab05_2;

/**
 * Created by shorti1996 on 30.03.2016.
 */
public interface Stack {
    public void push(Object value); // odłóż na stos
    public Object pop() /*throws EmptyStackException*/; //pobierz ze stosu
    public Object peek() /*throws EmptyStackException*/; //odczytaj ( nieniszcząco ) ze stosu
    public void clear(); //czyść stos
    public int size(); // wysokość stosu
    public boolean isEmpty(); //true jeśli stos jest pusty
}

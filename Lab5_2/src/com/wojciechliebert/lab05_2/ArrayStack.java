package com.wojciechliebert.lab05_2;

import javax.swing.text.html.parser.Element;

/**
 * Created by shorti1996 on 30.03.2016.
 */
public class ArrayStack {
    public Object[] _array;
    public int _size;

    public ArrayStack(){
        clear();
    }

    public ArrayStack(int size){
        _array = new Object[size];
        _size = 0;
    }

    //czyść stos
    public void clear(){
        _array = new Object[5];
        _size = 0;
    }

    // odłóż na stos
    public void push(Object value){
        if (((_size+1) / _array.length) >= 0.8){
            MakeBigger();
        }
        for(int i = _size; i > 0; i--){
            _array[i] = _array[i-1];
        }
        _array[0] = value;
        _size++;
    }

    public void MakeBigger() {
        Object[] newArray = new Object[_size * 2];
        for (int j = 0; j < _size; j++) {
            newArray[j] = _array[j];
        }
        _array = newArray;
    }

    public void MakeSmaller(){
        Object[] newArray = new Object[(int)(_array.length * 0.5)];
        for (int j = 0; j < _size; j++) {
            newArray[j] = _array[j];
        }
        _array = newArray;
    }

    //pobierz ze stosu
    public Object pop(){
        Object objectToReturn = new Object();
        double temp = (double)(_size-1) / (double)(_array.length);
        if ((temp) < 0.25){
            MakeSmaller();
        }
        objectToReturn = _array[0];
        for(int i = 0; i < _size-1; i++){
            _array[i] = _array[i+1];
        }
        _size--;
        return objectToReturn;
    }

    //odczytaj ( nieniszcząco ) ze stosu
    public Object peek(){
        return _array[0];
    }

    // wysokość stosu
    public int size(){
        return _size;
    }

    //true jeśli stos jest pusty
    public boolean isEmpty(){
        if (_size == 0) return true;
        else return false;
    }
}

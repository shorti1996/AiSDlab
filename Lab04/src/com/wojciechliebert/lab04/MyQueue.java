package com.wojciechliebert.lab04;

/**
 * Created by shorti1996 on 09.03.2016.
 */
public class MyQueue{
    public Element first = null; // puste miejsce do wykorzystania
    public int _size;    // dlugość listy

    public MyQueue(){
        clear();
    }

    public MyQueue(int size){
        _size = size;
        clear();
    }

    public ValueIterator ValueIterator(){
        return new ValueIterator(this);
    }

    public ValueIterator iterator(){
        return new ValueIterator(this);
    }

    public ValueIterator getIterator(){
        return new ValueIterator(this);
    }

    public void clear() {
        first = null;
        _size = 0;
    }

    public Element getElement(int index){
        int i = 0;
        if(first == null){
            first = new Element(null);
            first.setNext(null);
            return first;
        }
        for (Element e = first; (e = e.getNext()) != null; i++) {
            if (i == index) {
                return e;
            }
        }
        return first;
    }

    // dodaj na koniec
    public void enqueue(Object value){
        int index = _size;
        if(index < 0 || index > _size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        if (_size != 0) index--;
        element.attachAfter(getElement(index));
        ++_size;
    }

    public Object dequeue (){
        Element element1 = getElement(0);
        Element element2 = getElement(1);
        first = element1;
        --_size;
        return element1.getValue();
    }

    public int size() {
        return _size;
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
    }

    public boolean isEmpty(){
        if (_size == 0) return true;
        else return false;
    }

}

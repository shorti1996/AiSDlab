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

    /*public Iterator iterator()
    {  return new ValueIterator(); }*/

    public void clear() {
        // _head.setPrevious(_head);
        //_head.setNext(_head);
        first = null;
        _size = 0;
    }

    // dodaj na wskazaną pozycję
    /*public void insert(int index, Object value) throws IndexOutOfBoundsException{
        if(index < 0 || index > _size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        element.attachBefore(getElement(index));
        ++_size;
    }*/
    /*public void insert(int index, Object value) throws IndexOutOfBoundsException{
        if(index < 0 || index > _size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        element.attachAfter(getElement(index));
        ++_size;
    }*/
    public void insert(int index, Object value) throws IndexOutOfBoundsException{
        if(index < 0 || index > _size) throw new IndexOutOfBoundsException();
        Element element = new Element(value);
        if (_size != 0) index--;
        element.attachAfter(getElement(index));
        ++_size;
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
    /*public Element getElement(int index)
    {return index< _size/2 ? getElementForwards(index) : getElementBackwards(index); }

    // dojście do podanej pozycji w przód
    private Element getElementForwards(int index) {
        Element element = _head.getNext();

        for (int i = index; i > 0; --i)
            element = element.getNext();
        return element;
    }

    private Element getElementBackwards(int index) {
        Element element = _head;
        for (int i = _size - index; i > 0; --i)
            element = element.getPrevious();
        return element;
    }*/


    public int getIndex(Element element){
        int index = 0;
        for (Element e = new Element(); (e = e.getNext()) != null; index++){
            if (e == element){
                return index;
            }
        }

        return -1;
    }

    // dodaj na koniec
    public void enqueue(Object value){
        insert(size(), value);
    }

    public void dequeue (){
        delete(0);
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        if (index == 0){
            Element element1 = getElement(index);
            Element element2 = getElement(index+1);
            first = element1;
            --_size;
            return null;
        }
        index--;
        checkOutOfBounds(index);
        Element element = getElement(index);
        element.detach();
        --_size;
        return element.getValue();
    }
    public boolean delete(Object value) {
        Element e = first;
        while (e != null && ! value.equals(e.getValue()))
            e = e.getNext();
        if (e != null) {
            e.detach(); --_size; return true;
        }
        else return false;
    }

    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element element = getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    public int size() {
        return _size;
    }

    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
    }

    /*
    ITERATOR
     */
    //public final class ValueIterator /*implements Iterator*/ {
       /* private Element _current = _head;
        public void first()
        { _current = _head.getNext(); }

        public void last()
        { _current = _head.getPrevious(); }

        public boolean isDone()
        { return _current == _head; }

        public void next()
        { _current = _current.getNext(); }

        public void previous()
        { _current = _current.getPrevious(); }

        public Object current() throws IndexOutOfBoundsException {
            if (isDone())
                /*throw new IndexOutOfBoundsException()*/;
            /*return _current.getValue();
        }
    }*/

    public boolean isEmpty(){
        if (_size == 0) return true;
        else return false;
    }

}

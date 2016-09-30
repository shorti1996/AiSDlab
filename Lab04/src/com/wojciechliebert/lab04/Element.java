package com.wojciechliebert.lab04;

import java.util.concurrent.RecursiveTask;

/**
 * Created by shorti1996 on 09.03.2016.
 */
public class Element {
    public Object objectContained;
    //public int index;
    //public Element previous;
    public Element next;

    public Element(){
        objectContained = null;
        next = null;
    }

    public Element(Object o){
        objectContained = o;
        //previous = null;
        next = null;
    }

    public Element(Object o, Element next){
        objectContained = o;
        this.next = next;
    }

    public void setNext(Element e){
        this.next = e;
    }

    /*public void setPrevious(Element e){
        this.previous = e;
    }*/

    public Element getNext(){
        return this.next;
    }

    public void attachAfter(Element previous) {
        if (previous == null){
            previous = this;
            setNext(next);
        }
        else{
            Element next = previous.getNext();
            setNext(next);
            previous.setNext(this);
        }
    }

    public void detach() {
        setNext(next.next);
    }

    public Object getValue(){
        return objectContained;
    }

    public void setValue(Object o){
        objectContained = o;
    }


}

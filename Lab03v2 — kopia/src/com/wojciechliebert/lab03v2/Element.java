package com.wojciechliebert.lab03v2;

import java.util.concurrent.RecursiveTask;

/**
 * Created by shorti1996 on 09.03.2016.
 */
public class Element {
    public Object objectContained;
    //public int index;
    public Element previous;
    public Element next;

    public Element(){
        objectContained = null;
        previous = null;
        next = null;
    }

    public Element(Object o){
        objectContained = o;
        previous = null;
        next = null;
    }

    /*public Element(Object o, Element prev){
        objectContained = o;
        previous = prev;
    }*/

    public Element(Object o, Element next){
        objectContained = o;
        this.next = next;
    }

    public void setNext(Element e){
        this.next = e;
    }

    public void setPrevious(Element e){
        this.previous = e;
    }

    public Element getNext(){
        return this.next;
    }

    public Element getPrevious(){
        return this.previous;
    }

    /*public void attachBefore(Element next) {
        Element previous = next.getPrevious();
        setNext(next);
        setPrevious(previous);
        next.setPrevious(this);
        previous.setNext(this);
    }*/
    public void attachBefore(Element next) {
        Element previous = next.getPrevious();
        setNext(next);
        setPrevious(previous);
        next.setPrevious(this);
        previous.setNext(this);
    }

    /*public void attachAfter(Element previous) {
        Element next = previous.getNext();
        setNext(next);
        setPrevious(previous);
        next.setPrevious(this);
        previous.setNext(this);
    }*/
    public void attachAfter(Element previous) {
        Element next = previous.getNext();
        setNext(next);
        setPrevious(previous);
        next.setPrevious(this);
        previous.setNext(this);
    }

    public void detach() {
        previous.setNext(next);
        next.setPrevious(previous);
    }

    public Object getValue(){
        return objectContained;
    }

    public void setValue(Object o){
        objectContained = o;
    }


}

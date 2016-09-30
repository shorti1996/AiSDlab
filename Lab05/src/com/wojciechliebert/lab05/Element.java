package com.wojciechliebert.lab05;

/**
 * Created by shorti1996 on 30.03.2016.
 */
public class Element {
    public Object objectContained;
    public Element next;

    public Element() {
        objectContained = null;
        next = null;
    }

    public Element(Object o) {
        objectContained = o;
        next = null;
    }

    public void setNext(Element e){
        this.next = e;
    }

    public Element getNext(){
        return this.next;
    }

    public void attachAfter(Element previous) {
        if (previous == null){
            previous = this;
            //previous = new Element(this.getValue());
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
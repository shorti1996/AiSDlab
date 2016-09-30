package com.wojciechliebert.lab05_2;

public class Main {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(new Liczba(0));
        arrayStack.push(new Liczba(1));
        arrayStack.push(new Liczba(2));
        arrayStack.push(new Liczba(3));
        arrayStack.push(new Liczba(4));
        arrayStack.push(new Liczba(5));

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("KONIEC\n");

        arrayStack.push(new Liczba(5));
        arrayStack.push(new Liczba(6));
        System.out.println("Podglądanie: " + arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}

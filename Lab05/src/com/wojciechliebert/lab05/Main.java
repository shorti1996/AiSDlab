package com.wojciechliebert.lab05;

public class Main {

    public static void main(String[] args) {
	    MyStack stack = new MyStack();
        stack.push(new Liczba(0));
        stack.push(new Liczba(1));
        stack.push(new Liczba(2));

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}

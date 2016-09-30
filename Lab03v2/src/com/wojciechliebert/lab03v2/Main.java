package com.wojciechliebert.lab03v2;
//import com.wojciechliebert.lab03v2.*;

public class Main {

    public static void main(String[] args) {
        LinkedList lista = new LinkedList();

        lista.add(new Student(123456, "aaa", "bbb", 3.0));
        lista.add(new Student(666666, "aaa", "bbb", 3.0));
        lista.add(new Student(654321, "ccc", "ddd", 3.0));
        lista.add(new Student(985632, "eee", "fff", 3.0));
        //lista.add(new Student(741258, "ggg", "hhh", 4.0));
        ValueIterator it = lista.iterator();

        it.first();
        while(!it.isDone())
        {
            System.out.println(it.current());
            it.next();
        }
        System.out.println("Koniec");

        System.out.println();
        it.first();
        Student gotStudent = new Student();
        int index = 1;
        gotStudent = (Student) lista.getElement(index).getValue();
        //Element newElement = lista.getElement(1);
        System.out.println("Student na miejscu " + index + " to: " + gotStudent);

        System.out.println();
        it.first();
        lista.delete(1);
        it.first();
        while(!it.isDone())
        {
            System.out.println(it.current());
            it.next();
        }
        System.out.println("Koniec");
    }
}

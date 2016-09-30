package com.wojciechliebert.lab02;

public class Main {

    public static void main(String[] args) {
	    Student s1 = new Student(123456, "abc", "def", 3.0);
        Student s2 = new Student(654321, "ghi", "jkl", 4.0);
        Student s3 = new Student(785412, "mno", "pqr", 2.0);
        ListaStudentow listaStudentow = new ListaStudentow(10);
        /*listaStudentow[0] = s1;
        listaStudentow[1] = s2;
        listaStudentow[2] = s3;*/
        listaStudentow.DodajStudenta(s1);
        listaStudentow.DodajStudenta(s2);
        listaStudentow.DodajStudenta(s3);

        //listaStudentow.Pokaz();
        listaStudentow.WyswietlStudentow();
        listaStudentow.WstawOcene(123456, 3.5);
        System.out.printf("%n%n");
        listaStudentow.WyswietlStudentow();
    }
}

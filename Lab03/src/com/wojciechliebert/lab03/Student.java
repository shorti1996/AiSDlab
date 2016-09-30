package com.wojciechliebert.lab03;

public class Student {
    int indeks;
    String nazwisko;
    String imie;
    double ocena;

    public void SetOcena(double ocena){
        this.ocena = ocena;
    }

    public Student(){
        indeks = 0;
        imie = "";
        nazwisko = "";
    }
    public Student(int indeks, String n, String i, double o){
        this.indeks = indeks;
        this.nazwisko = n;
        this.imie = i;
        this.ocena = o;
    }

    @Override
    public String toString(){
        String s = indeks + " " + nazwisko + " " + imie + " " + ocena;
        return s;
    }
}

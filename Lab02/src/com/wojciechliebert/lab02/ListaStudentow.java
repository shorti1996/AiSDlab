package com.wojciechliebert.lab02;

/**
 * Created by shorti1996 on 02.03.2016.
 */
public class ListaStudentow {
    Student[] lista;
    ArrayIterator ai;

    public ListaStudentow(){
        lista = new Student[99];
        ai = new ArrayIterator(lista);
    }

    public ListaStudentow(int size){
        lista = new Student[size];
        ai = new ArrayIterator(lista);
    }

    public boolean DodajStudenta(Student s){
        for (int i = 0; i < lista.length; i++){
            if (lista[i] == null){
                lista[i] = s;
                return true;
            }
        }
        return false;
    }

    public void Pokaz(){
        for (int i = 0; i < lista.length; i++){
            if(lista[i] != null)
                System.out.println(lista[i].toString());
            else return;
        }
    }

    public void WyswietlStudentow(){
        try{
            ai.first();
            Student s = (Student)ai.current();
            System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            while (ai.hasNext()){
                ai.next();
                s = (Student)ai.current();
                System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            }
        }
        catch (NullPointerException ex){

        }
    }

    public void WyswietlZaliczyli(){
        try{
            ai.first();
            FilterIterator fi = new FilterIterator(ai, new PredZaliczyli());
            fi.first();
            Student s = (Student)fi.current();
            System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            while (!fi.isDone()){
                fi.next();
                s = (Student)fi.current();
                System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            }
        }
        catch (IndexOutOfBoundsException ex){
        }
    }

    public Student[] KopiujZaliczyli(){
        Student[] lista = new Student[99];
        int index = 0;
        try{
            ai.first();
            FilterIterator fi = new FilterIterator(ai, new PredZaliczyli());
            fi.first();
            Student s = (Student)fi.current();
            lista[index] = s;
            //System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);

            while (!fi.isDone()){
                fi.next();
                index++;
                s = (Student)fi.current();
                lista[index] = s;
                //System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            }
        }
        catch (IndexOutOfBoundsException ex){
        }
        return lista;
    }

    public void WyswietlNieZaliczyli(){
        try{
            ai.first();
            FilterIteratorNieZaliczyli fi = new FilterIteratorNieZaliczyli(ai, new PredNieZaliczyli());
            fi.first();
            Student s = (Student)fi.current();
            System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            while (!fi.isDone()){
                fi.next();
                s = (Student)fi.current();
                System.out.printf("%06d %10s %10s %.2f %n", s.indeks, s.nazwisko, s.imie, s.ocena);
            }
        }
        catch (IndexOutOfBoundsException ex){
        }
    }


    public boolean WstawOcene(int indeks, double ocena){
        boolean success = false;
        ai.first();
        //Student s = new Student();
        while(ai.hasNext()){
            Student s = (Student)ai.current();
            if(s.indeks == indeks){
                s.ocena = ocena;
                return true;
            }
        }
        return success;
    }
}

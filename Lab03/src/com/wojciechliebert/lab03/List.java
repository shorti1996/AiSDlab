package com.wojciechliebert.lab03;

/**
 * Created by shorti1996 on 09.03.2016.
 */

public interface List extends Iterable
    {
        // dodaj na wskazaną pozycję
        public void insert(int index, Object value) throws IndexOutOfBoundsException;

        // dodaj na koniec
        public void add(Object value);

        //usuń element ze wskazanej pozycji
        public Object delete(int index) throws IndexOutOfBoundsException;

        // usuń pierwsze wystąpienie wskazanej wartości
        public boolean delete(Object value);

        // usuń wszystkie elementy
        public void clear();

        // zmień element na wskazanej pozycji
        public Object set(int index, Object value) throws IndexOutOfBoundsException;
        // daj wartość wskazanego elementu
        public Object get(int index) throws IndexOutOfBoundsException;

        // znajdź pozycję podanej wartości; -1 gdy nie ma
        public int indexOf(Object value);

        // czy dana wartość występuje na liście
        public boolean contains(Object value);

        // liczba elementów na liście
        public int size();

        // czy pusta lista
        public boolean isEmpty();
}



package com.wojciech.liebert.lab11;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by shorti1996 on 11.05.2016.
 */
public class HashTable {
    Object[] _table;
    int _size = 0;

    public HashTable(){
        _table = new Object[7];
    }

    public HashTable(int size){
        _table = new Object[size];
    }

    public boolean Insert(int key, Object val){
        if (Insert(key, val, null)){
            _size++;
            return true;
        }
        else{
            Insert(key, val, null);
            _size++;
            return true;
        }
    }

    public boolean Insert(int key, Object val, Object[] table){
        if (table == null){
            table = _table;
        }
        if (AdjustSize(table)){
            return false;
        }
        HashObject hObj = new HashObject(key, val);
        int i = Hash(hObj.key, table);

        if (table[i] == null){
            LinkedList<HashObject> ll = new LinkedList<>();
            ll.add(hObj);
            table[i] = ll;
        }
        else {
            LinkedList<Object> linkedList = (LinkedList<Object>)table[i];
            linkedList.add(hObj);
        }

        return true;
    }

    private boolean AdjustSize(Object[] tab) {
        double check = (double)_size / (double) tab.length;
        if (check >= 0.75){
            MakeBigger();
            return true;
        }
        return false;
    }

    public Object GetObject(int key){
        int i = Hash(key);
        if (_table[i] == null){
            return null;
        }
        else {
            LinkedList<HashObject> ll = (LinkedList<HashObject>)_table[i];
            for (HashObject hashObject : ll) {
                if (hashObject.key == key){
                    return hashObject.value;
                }
            }
        }
        return null;
    }

    public void MakeBigger(){
        int newSize = _table.length * 2;
        newSize = NextPrime(newSize);
        Object[] newTable = new Object[newSize];
        for (int i = 0; i < _table.length; i++){
            if (_table[i] != null){
                LinkedList<HashObject> ll = (LinkedList<HashObject>)_table[i];
                for (HashObject hashObject : ll) {
                    Insert(hashObject.key, hashObject.value, newTable);
                }
            }
        }
        System.out.println("Tablica powiekszona z " + _table.length + " na " + newTable.length);
        _table = newTable;
    }

    private int NextPrime(int number) {
        for (int i = 2; i < Math.sqrt(number); i++){
            if (number % i == 0){
                return NextPrime(number+1);
            }
        }
        return number;
    }

    private int Hash(int key, Object[] tab){
        int charKey;
        String hashString = "";
        char character;
        while (key > 0) {
            charKey = ( key % 10);
            key = key / 10;
            character = (char)(charKey + 99);
            hashString += character;
        }
        int hash = hashString.hashCode();
        int i = hash % tab.length;
        return i;
    }

    public int Hash(int key){
        return Hash(key, _table);
    }

    public int size(){
        return _size;
    }

    public boolean CzyZawiera(int key){
        if (GetObject(key) == null){
            return false;
        }
        else {
            return true;
        }
    }

    public String Dump(){
        String toReturn = "";
        for (int i = 0; i < _table.length; i++){
            if (_table[i] == null){
                toReturn += "null ";
            }
            else{
                LinkedList<HashObject> ll = new LinkedList<HashObject>((LinkedList<HashObject>)_table[i]);
                for (HashObject ho :
                        ll) {
                    if (ho != ll.getLast()) {
                        toReturn += ho.value + "+";
                    }
                    else {
                        toReturn += ho.value + " ";
                    }
                }

            }
        }
        return toReturn;
    }

}

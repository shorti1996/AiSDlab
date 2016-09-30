package com.wojciech.liebert.lab11;

/**
 * Created by shorti1996 on 11.05.2016.
 */
public class HashTable {
    HashObject[] _table;
    int _size = 0;

    public HashTable(){
        _table = new HashObject[7];
    }

    public HashTable(int size){
        _table = new HashObject[size];
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

    public boolean Insert(int key, Object val, HashObject[] table){
        if (table == null){
            table = _table;
        }
        if (AdjustSize(table)){
            return false;
        }
        HashObject hObj = new HashObject(key, val);
        int i = Hash(hObj.key, table);
        i = FindNextEmpty(i, table);
        table[i] = hObj;

        //_size++;
        return true;
    }

    public boolean Insert2(int key, Object val){
        if (Insert2(key, val, null)){
            _size++;
            return true;
        }
        else{
            Insert2(key, val, null);
            _size++;
            return true;
        }
    }

    public boolean Insert2(int key, Object val, HashObject[] table){
        if (table == null){
            table = _table;
        }
        if (AdjustSize2(table)){
            return false;
        }
        HashObject hObj = new HashObject(key, val);
        int i = Hash(hObj.key, table);

        i = FindNextEmpty2(i, table);
        table[i] = hObj;

        //_size++;
        return true;
    }

    private boolean AdjustSize(Object[] tab) {
        double check = (double)_size / (double) tab.length;
        if (check >= 0.5){
            MakeBigger();
            return true;
        }
        return false;
    }

    private boolean AdjustSize2(Object[] tab) {
        double check = (double)_size / (double) tab.length;
        if (check >= 0.5){
            MakeBigger2();
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
            if (_table[i].key == key){
                return _table[i].value;
            }
            else {
                for (int j = 0; j < _table.length; j++){
                    if (j == _table.length){
                        j = -1;
                    }
                    if (_table[j] != null && _table[j].key == key){
                        return  _table[j].value;
                    }
                }
            }
        }
        return null;
    }

    public Object GetObject2(int key){
        return GetObject2(key, key);
    }

    public Object GetObject2(int key, int hash){
        int i = Hash(hash);
        if (_table[i] == null){
            return null;
        }
        else {
            if (_table[i].key == key){
                return _table[i].value;
            }
            else {
                return GetObject2(key, i);
            }
        }
        //return null;
    }

    private int FindNextEmpty(int index, Object[] tab){
        for (int i = index; i < Integer.MAX_VALUE; i++){
            if (tab[i] == null){
                return i;
            }
            else {
                if (i >= tab.length-1){
                    i = -1;
                }
            }
        }
        return 0;
    }

    private int FindNextEmpty2(int index, Object[] tab){
        if (tab[index] == null){
            return index;
        }
        else {
            return FindNextEmpty2(Hash(index, tab), tab);
        }
        //return 0;
    }

    private int FindNextEmpty(int index) {
        return FindNextEmpty(index, _table);
    }

    public void MakeBigger(){
        int newSize = _table.length * 2;
        newSize = NextPrime(newSize);
        HashObject[] newTable = new HashObject[newSize];
        for (int i = 0; i < _table.length; i++){
            if (_table[i] != null){
                Insert(_table[i].key, _table[i].value, newTable);
            }
        }
        System.out.println("Tablica powiekszona z " + _table.length + " na " + newTable.length);
        _table = newTable;
    }

    public void MakeBigger2(){
        int newSize = _table.length * 2;
        newSize = NextPrime(newSize);
        HashObject[] newTable = new HashObject[newSize];
        for (int i = 0; i < _table.length; i++){
            if (_table[i] != null){
                Insert2(_table[i].key, _table[i].value, newTable);
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
        int hash = hashString.hashCode() + 101;
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
                toReturn += _table[i].key + " ";
            }
        }
        return toReturn;
    }

}

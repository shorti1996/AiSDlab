package com.wojciech.liebert.lab14;

import java.util.*;

/**
 * Created by shorti1996 on 01.06.2016.
 */
public class PriorityQ<Key> implements Iterable<Key> {

    private Key[] pq; // store items at indices 1 to N
    private int N; // number of items on priority queue
    private Comparator<Key> comparator; // optional comparator
    
    @Override
    public String toString(){
        String toReturn = "";
        Iterator<Key> i = iterator();

        while(i.hasNext()){
             toReturn += i.next().toString() + " ";
        }
        return toReturn;
    }

    public List<Key> MakeList(){
        List<Key> list = new LinkedList<>();
        PriorityQ<Key> copy = CopyMe();
        while(!copy.isEmpty()){
            list.add(copy.delMin());
        }

        return list;
    }

    public PriorityQ<Key> CopyMe(){
        PriorityQ<Key> copy;
        copy = new PriorityQ<Key>(size());
        for (int i = 1; i <= N; i++) {
            copy.insert(pq[i]);
        }
        return copy;
    }

    public Key deleteAt(int index) {
        if (isEmpty() || index < 1 || index > N) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        Key tmp = pq[index];
        exch(index, N);
        N--;
        if (greater(tmp, pq[index])) {
            swim(index);
        } else {
            sink(index);
        }
        assert isMinHeap();
        return tmp;
    }

    public void changePriority(int index, Key newKey){
        if (isEmpty())
            return;
        //Key k = pq[index];
        deleteAt(index);
        insert(newKey);
    }

    public PriorityQ(Key[] keys) {
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < N; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = N / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public PriorityQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public PriorityQ(){this(1);}

    public PriorityQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    /*public PriorityQ(Key[] tab){
        this(1);
        for (Key o :
                tab) {
            insert(o);
        }
    }*/

    public PriorityQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public void insert(Key x) {
        // double size of array if necessary
        if (N == pq.length - 1) {
            resize(2 * pq.length);
        }

        // add x, and percolate it up to maintain heap invariant
        pq[++N] = x;
        swim(N);
        assert isMinHeap();
    }

    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private boolean greater(Key i, Key j) {
        if (comparator == null) {
            return ((Comparable<Key>) i).compareTo(j) > 0;
        } else {
            return comparator.compare(i, j) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a min heap?
    public boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..N] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > N) {
            return true;
        }
        int left = 2 * k, right = 2 * k + 1;
        if (left <= N && greater(k, left)) {
            return false;
        }
        if (right <= N && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }

    public Key delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        exch(1, N);
        Key min = pq[N--];
        sink(1);
        pq[N + 1] = null; // avoid loitering and help with garbage collection
        if ((N > 0) && (N == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        // create a new pq

        private PriorityQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) {
                copy = new PriorityQ<Key>(size());
            } else {
                copy = new PriorityQ<Key>(size(), comparator);
            }
            for (int i = 1; i <= N; i++) {
                copy.insert(pq[i]);
            }
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Key next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return copy.delMin();
        }
    }
}

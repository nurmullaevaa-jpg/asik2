package org.example;
import org.example.MyList;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override public void add(T item) { addLast(item); }
    @Override public T getFirst() { return (head != null) ? head.data : null; }
    @Override public T getLast() { return (tail != null) ? tail.data : null; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override public void set(int index, T item) {}
    @Override public void add(int index, T item) {}
    @Override public T get(int index) { return null; }
    @Override public void remove(int index) {}
    @Override public void removeFirst() {
        if (size == 0) return;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }
    @Override public void removeLast() {}
    @Override public void sort() {}
    @Override public int indexOf(Object object) { return -1; }
    @Override public int lastIndexOf(Object object) { return -1; }
    @Override public boolean exists(Object object) { return false; }
    @Override public Object[] toArray() { return new Object[0]; }
}
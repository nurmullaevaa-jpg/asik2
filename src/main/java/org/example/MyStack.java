package org.example;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) return null;
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}